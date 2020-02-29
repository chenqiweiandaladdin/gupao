package design.single;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public  class ContainerSingleton {

    private ContainerSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getBean(String clasName){
        synchronized (ioc) {
            if (!ioc.containsKey(clasName) ){
                Object obj = null;
                try {
                    obj = Class.forName(clasName).newInstance();
                    ioc.put(clasName, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(clasName);
            }
        }
    }






}


