package parserModel;

import java.util.HashMap;
import java.util.Map;

public class Variables {
    private static final Map<String, Double> myVariables = new HashMap<>();

    public void setVariable(String name, double value){
        myVariables.put(name, value);
    }
    public double getVariable(String name){
        return myVariables.getOrDefault(name, 0.0);
    }
}

