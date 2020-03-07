package design.decorator;

import java.util.ArrayList;
import java.util.List;

public  class Navigation {
    private List<Function> functions = new ArrayList<>();

    public void addFunction(Function function) {
        functions.add(function);
    }

    public List<Function> getFunctions() {
        return functions;
    }


}
