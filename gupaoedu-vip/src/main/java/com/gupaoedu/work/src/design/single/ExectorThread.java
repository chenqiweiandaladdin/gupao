package design.single;

public class  ExectorThread  implements Runnable{

public void run() {
        Object singleton =  ContainerSingleton.getBean("builderA");
        System.out.println(Thread.currentThread().getName()+":"+singleton);
}
}


