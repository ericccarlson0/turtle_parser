package parserModel;

import parserModel.nodes.control.CallCommandNode;

import java.util.HashMap;
import java.util.Map;

/**
 * A Singleton object that contains Variable and TurtleData objects.
 */
public class GlobalData {
    private static final GlobalData INSTANCE = new GlobalData();

    private TurtleData myTurtle;
    private Map<String, Double> myVariables;
    private Map<String, CallCommandNode> myCommands;

    private GlobalData() {
        myTurtle = new TurtleData();
        myVariables = new HashMap<>();
        myCommands = new HashMap<>();
    }

    public static GlobalData getInstance() {
        return INSTANCE;
    }

    public void setVariable(String name, double value) {
        myVariables.put(name, value);
    }
    public double getVariable(String name){
        return myVariables.getOrDefault(name, 0.0);
    }
    public void setCommand(String commandName, CallCommandNode command){
        myCommands.put(commandName, command);
    }
    public CallCommandNode getCommand(String commandName){
        return myCommands.getOrDefault(commandName, null);
    }
    public TurtleData turtleData() {
        return myTurtle;
    }
    public void clear() {
        myTurtle.clear();
        myVariables.clear();
    }
}

