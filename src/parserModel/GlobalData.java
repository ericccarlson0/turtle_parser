package parserModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import parserModel.exceptions.NoSuchCommandException;
import parserModel.nodes.control.CallCommandNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Singleton object that contains Variable and TurtleData objects.
 *
 * @author Mariusz Derezinski-Choo
 */
public class GlobalData {
    public static final double DEFAULT_VARIABLE_VALUE = 0.0;

    private Map<Double, TurtleData> myTurtles;
    private Map<String, Double> myVariables;
    private Map<String, CallCommandNode> myCommands;
    private ObservableList<String> myObservableCommands;
    private ObservableList<String> myObservableVariables;

    /**
     * Construct a GlobalData object, private to ensure the class is Singleton.
     */
    public GlobalData() {
        myTurtles = new HashMap<>();
        myTurtles.put(0.0, new TurtleData()); //FIXME?
        myVariables = new HashMap<>();
        myCommands = new HashMap<>();
        myObservableVariables = FXCollections.observableArrayList();
        myObservableCommands = FXCollections.observableArrayList();
    }

    /**
     * Store a variable as a specified value.
     * @param name the name of the variable.
     * @param value the value of the variable to be stored.
     */
    public void setVariable(String name, double value) {
        myVariables.put(name, value);
        if(! myObservableVariables.contains(name)){
            myObservableVariables.add(name);
        }
    }

    /**
     * Retrieve the value of a variable.
     * @param name the name of the variable.
     * @return the value of the variable, or DEFAULT_VARIABLE_VALUE if the variable does not exist.
     */
    public double getVariable(String name){
        return myVariables.getOrDefault(name, DEFAULT_VARIABLE_VALUE);
    }

    /**
     * Store a CallCommandNode as associated with the provided command name; adds the command name
     * to the namespace if it does not exist yet.
     *
     * @param commandName the name of the command.
     * @param command the command that will be associated with this name.
     */
    public void setCommand(String commandName, CallCommandNode command){
        myCommands.put(commandName, command);
        if(! myObservableCommands.contains(commandName)){
            myObservableCommands.add(commandName);
        }
    }

    /**
     * Returns a copy of the 'call command' associated with the command name.
     * A copy is generated so that unique parameter values can be passed before execution.
     * @param commandName the name of the variable.
     * @return a copy of the call command.
     * @throws NoSuchCommandException if the command does not exist in the namespace.
     */
    public CallCommandNode getCommand(String commandName){
        CallCommandNode ret =  myCommands.get(commandName);
        if(ret == null){
            throw new NoSuchCommandException(commandName);
        }
        return ret.copy();
    }
    public List<Double> getAllTurtles(){
        return new ArrayList<>(myTurtles.keySet());
    }

    /**
     * Get the turtle data associated with the turtle's ID.
     * @return an object that encapsulates the turtle data.
     */
    public TurtleData turtleData(double id) {
        myTurtles.putIfAbsent(id, new TurtleData());
        return myTurtles.get(id);
    }

    public void createTurtles(double id){
            System.out.println("creating turtle(s) of ID: " + id);
            for (int i = 0; i <= id; i++) {
                myTurtles.putIfAbsent(id, new TurtleData());
            }
    }

    /**
     * @return An observable list of the available variables in the namespace.
     */
    public ObservableList<String> observableVariableList(){
        return myObservableVariables;
    }

    /**
     * @return an observable list of the available commands in the namespace.
     */
    public ObservableList<String> observableCommandList(){
        return myObservableCommands;
    }

    /**
     * Wipe all of the data in the namespace.
     */
    public void clear() {
        for (TurtleData t : myTurtles.values()) {
            t.clear();
        }
        myVariables.clear();
        myCommands.clear();
        myObservableVariables.clear();
    }
}

