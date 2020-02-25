package parserModel;

import java.util.HashMap;
import java.util.Map;

public class GlobalData {
    private static final GlobalData INSTANCE = new GlobalData();

    private TurtleData myTurtle;
    private Map<String, Double> myVariables;

    private GlobalData(){
        myTurtle = new TurtleData();
        myVariables = new HashMap<>();
    }

    public static GlobalData getInstance(){
        return INSTANCE;
    }

    public void setVariable(String name, double value){
        myVariables.put(name, value);
    }
    public double getVariable(String name){
        return myVariables.getOrDefault(name, 0.0);
    }
    public TurtleData turtleData(){
        return myTurtle;
    }
}

