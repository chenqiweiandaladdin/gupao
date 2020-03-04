package design.proxy.dynamicproxy.gpproxy.proxy;

import design.proxy.dynamicproxy.gpproxy.client.IPerson;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class GPProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader classLoader, Class<?> [] interfaces, GPInvocationHandler h){
       try {
           //1、动态生成源代码.java文件
           String src = generateSrc(interfaces);

//           System.out.println(src);
           //2、Java文件输出磁盘
           String filePath = GPProxy.class.getResource("").getPath();
//           System.out.println(filePath);
           File f = new File(filePath + "$Proxy0.java");
           FileWriter fw = new FileWriter(f);
           fw.write(src);
           fw.flush();
           fw.close();

           //3、把生成的.java文件编译成.class文件
           JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
           StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
           Iterable iterable = manage.getJavaFileObjects(f);

          JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
          task.call();
          manage.close();

           //4、编译生成的.class文件加载到JVM中来
          Class proxyClass =  classLoader.findClass("$Proxy0");
          Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
          f.delete();

           //5、返回字节码重组以后的新的代理对象
           return c.newInstance(h);
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append(GPProxy.class.getPackage() + ";").append(ln);
        sb.append("import ").append(interfaces[0].getName()).append(";").append(ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public final class $proxy0 implements " + interfaces[0].getName() + " {").append(ln);
        sb.append("DjjInvocationHandler h;").append(ln);
        sb.append("public $proxy0(DjjInvocationHandler h){ ").append(ln);
        sb.append("this.h = h;").append(ln);
        sb.append("}").append(ln);
        // 开始写方法
        for (Method method : interfaces[0].getMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();

            StringBuffer paramTypeName = new StringBuffer();
            StringBuffer paramTypeValue = new StringBuffer();
            StringBuffer paramTypeClass = new StringBuffer();

            // 组装参数
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                String type = parameterType.getName();
                String paramName = toLowerFirstCase(parameterType.getSimpleName());
                paramTypeName.append(type + " " + paramName);
                paramTypeValue.append(paramName);
                paramTypeClass.append(parameterType.getName() + ".class");
                if(i < parameterTypes.length - 1){
                    paramTypeName.append(",");
                    paramTypeValue.append(",");
                    paramTypeClass.append(",");
                }
            }

            sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramTypeName + "){").append(ln);
            sb.append("try{").append(ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[]{" + paramTypeClass.toString() + "});").append(ln);
            if(method.getReturnType() != void.class){
                sb.append("return ");
                sb.append("(" + method.getReturnType().getName() + ")");
                sb.append("(this.h.invoke(this,m,new Object[]{" + paramTypeValue + "}));").append(ln);
            }else{
                sb.append("this.h.invoke(this,m,new Object[]{" + paramTypeValue + "});").append(ln);
            }
            sb.append("}catch(Error _ex) { }").append(ln);
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}").append(ln);
            if(method.getReturnType() != void.class){
                sb.append("return null;");
            }
            sb.append("}").append(ln);
        }

        sb.append("}").append(ln);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

//    public static void main(String[] args) {
//        generateSrc(new Class[]{IPerson.class});
//
//    }
}
