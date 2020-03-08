package single;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getBean(Class<?> clazz) {
        synchronized (ioc) {
            if (!ioc.containsKey(clazz.getName())) {
                Object obj = null;
                try {
                    obj = Class.forName(clazz.getName()).newInstance();
                    ioc.put(clazz.getName(), obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(clazz.getName());
            }
        }
    }


}


