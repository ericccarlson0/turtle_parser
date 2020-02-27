package parserModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import parserModel.exceptions.NoSuchCommandException;
import parserModel.nodes.control.CallCommandNode;

import java.util.HashMap;
import java.util.Map;

/**
 * A Singleton object that contains Variable and TurtleData objects.
 *
 * @author Mariusz Derezinski-Choo
 */
public class GlobalData {
    private static final GlobalData INSTANCE = new GlobalData();
    public static final double DEFAULT_VARIABLE_VALUE = 0.0;

    private TurtleData myTurtle;
    private Map<String, Double> myVariables;
    private Map<String, CallCommandNode> myCommands;
    private ObservableList<String> myObservableCommands;
    private ObservableList<String> myObservableVariables;

    /**
     * Construct a GlobalData object, private to ensure the class is Singleton
     */
    private GlobalData() {
        myTurtle = new TurtleData();
        myVariables = new HashMap<>();
        myCommands = new HashMap<>();
        myObservableVariables = FXCollections.observableArrayList();
        myObservableCommands = FXCollections.observableArrayList();
    }

    /**
     * retrieve the instance of this class
     * @return the Singleton instance of the class
     */
    public static GlobalData getInstance() {
        return INSTANCE;
    }

    /**
     * Store a variable to the specified value
     * @param name the name of the variable
     * @param value the value of the variable to be stored
     */
    public void setVariable(String name, double value) {
        myVariables.put(name, value);
        if(! myObservableVariables.contains(name)){
            myObservableVariables.add(name);
        }
    }

    /**
     * retrieve the value of the variable
     * @param name the name of the variable
     * @return the value of the variable, or DEFAULT_VARIABLE_VALUE if the variable does not exist
     */
    public double getVariable(String name){
        return myVariables.getOrDefault(name, DEFAULT_VARIABLE_VALUE);
    }

    /**
     * Set store a CallCommandNode as being associated with the provided command name.
     * adds the command name to the namespace if it does not already exist
     *
     * @param commandName the name of the command
     * @param command the command that will be associated with this name
     */
    public void setCommand(String commandName, CallCommandNode command){
        myCommands.put(commandName, command);
        if(! myObservableCommands.contains(commandName)){
            myObservableCommands.add(commandName);
        }
    }

    /**
     * returns a copy of the call command associated with the command name
     * a copy is generated so that unique parameter values can be passed before execution
     * @param commandName the name of the variable
     * @return a copy of the call command
     * @throws  NoSuchCommandException if the command does not exist in the namespace
     */
    public CallCommandNode getCommand(String commandName){
        CallCommandNode ret =  myCommands.get(commandName);
        if(ret == null){
            throw new NoSuchCommandException(commandName);
        }
        return ret.copy();
    }

    /**
     * get the turtle data model
     * @return an object that encapsulates the turtle data
     */
    public TurtleData turtleData() {
        return myTurtle;
    }

    /**
     * @return An observable list of the available variables in the namespace
     */
    public ObservableList<String> observableVariableList(){
        return myObservableVariables;
    }

    /**
     * @return an observable list of the available commands in the namespace
     */
    public ObservableList<String> observableCommandList(){
        return myObservableCommands;
    }

    /**
     * clear all the data in the namespace;
     */
    public void clear() {
        myTurtle.clear();
        myVariables.clear();
        myCommands.clear();
        myObservableVariables.clear();
    }
}

