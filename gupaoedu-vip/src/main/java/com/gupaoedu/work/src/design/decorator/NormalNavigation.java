package design.decorator;

import java.util.List;

public  class NormalNavigation extends  Navigation {
    private Navigation navigation;

    public NormalNavigation(Navigation navigation) {
        this.navigation = navigation;
        Function function = new Function();
        function.setName("首页");
        function.setUrl("/home");
        addFunction(function);
    }

    public List<Function> getFunctions() {
        return super.getFunctions();
    }




}
