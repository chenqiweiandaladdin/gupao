package single;

import java.nio.Buffer;

public class ExectorThread implements Runnable {

    public void run() {
        Object singleton = ContainerSingleton.getBean(Builder.class);
        System.out.println(Thread.currentThread().getName() + ":" + singleton);

    }
}


