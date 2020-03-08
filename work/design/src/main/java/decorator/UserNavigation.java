package decorator;

import java.util.List;

public class UserNavigation extends Navigation {
    private Navigation navigation;

    public UserNavigation(Navigation navigation) {
        this.navigation = navigation;
        Function function = new Function();
        function.setName("作业");
        function.setUrl("/homeWork");
        addFunction(function);
    }

    public List<Function> getFunctions() {
        return super.getFunctions();
    }


}
