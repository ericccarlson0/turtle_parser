package parserModel;

import java.util.HashMap;
import java.util.Map;

public class GlobalData {
    private static final GlobalData INSTANCE = new GlobalData();

    private TurtleData

    private GlobalData()

    public void setVariable(String name, double value){
        myVariables.put(name, value);
    }
    public double getVariable(String name){
        return myVariables.getOrDefault(name, 0.0);
    }
}

