package gpproxy.client;


public class Zhangsan implements IPerson {

    public void findLove() {
        System.out.println("张三要求：肤白貌美大长腿");
    }

    @Override
    public void findLoveByContidions(String contidions) {
        System.out.println("带参数带方法");
    }


}
