package parserModel;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import parserModel.exceptions.NoSuchCommandException;
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
    private ObservableList<String> myObservableCommands;
    private ObservableList<String> myObservableVariables;

    private GlobalData() {
        myTurtle = new TurtleData();
        myVariables = new HashMap<>();
        myCommands = new HashMap<>();
        myObservableVariables = FXCollections.observableArrayList();
        myObservableCommands = FXCollections.observableArrayList();
        myObservableVariables.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                System.out.println("changed!");
                while(c.next()) {
                    if (c.wasAdded()) {
                        System.out.println("Added Variable " + c.getAddedSubList().get(0));
                    }
                }
            }
        });
    }

    public static GlobalData getInstance() {
        return INSTANCE;
    }

    public void setVariable(String name, double value) {
        //System.out.println("variable " + name + " set to value " + value);
        myVariables.put(name, value);
        if(! myObservableVariables.contains(name)){
            //System.out.println("adding " + name + "to the variable list");
            myObservableVariables.add(name);
        }
    }
    public double getVariable(String name){
        return myVariables.getOrDefault(name, 0.0);
    }
    public void setCommand(String commandName, CallCommandNode command){
        myCommands.put(commandName, command);
        if(! myObservableCommands.contains(commandName)){
            System.out.println("storing command " + commandName);
            myObservableCommands.add(commandName);
        }
    }
    public CallCommandNode getCommand(String commandName){
        CallCommandNode ret =  myCommands.get(commandName);
        if(ret == null){
            throw new NoSuchCommandException(commandName);
        }
        return ret.copy();
    }
    public TurtleData turtleData() {
        return myTurtle;
    }
    public ObservableList<String> observableVariableList(){
        return myObservableVariables;
    }
    public ObservableList<String> observableCommandList(){
        return myObservableCommands;
    }
    public void clear() {
        myTurtle.clear();
        myVariables.clear();
        myCommands.clear();
        myObservableVariables.clear();
    }
}

