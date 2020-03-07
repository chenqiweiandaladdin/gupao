package design.decorator;

import java.util.List;

public  class TestNavigation  {
       public static void main(String[] args) {
              Navigation basic = new Navigation();
              Navigation normal = new NormalNavigation(basic);
              Navigation user = new UserNavigation(basic);

              System.out.println(   JSON.toJSONString(normal.getFunctions()));
              System.out.println(   JSON.toJSONString(user.getFunctions()));

       }
    
}
