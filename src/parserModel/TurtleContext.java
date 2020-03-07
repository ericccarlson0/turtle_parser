package parserModel;

import execution.Executable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TurtleContext {
    private Queue<Executable> myExecutableQueue;
    private GlobalData myData;
    private ObservableList<Double> myActiveTurtles;
    private DoubleProperty myWorkingTurtle;

    public TurtleContext() {
        myActiveTurtles = FXCollections.observableArrayList();
        myData = new GlobalData();
        myExecutableQueue = new LinkedList<>();
        myWorkingTurtle = new SimpleDoubleProperty(1);
    }

    public Iterator<Executable> getExecutables(){
        return myExecutableQueue.iterator();
    }
    public void resetQueue(){
        myExecutableQueue = new LinkedList<>();
    }
    public void addToQueue(Executable ex){
        myExecutableQueue.add(ex);
    }

    public List<Double> getActiveTurtles(){
        return new ArrayList<>(myActiveTurtles);
    }
    public Collection<Double> replaceActiveTurtles(Collection<Double> ids){
        List<Double> ret = new ArrayList<>(myActiveTurtles);
        myActiveTurtles.clear();
        myActiveTurtles.addAll(ids);
        return ret;
    }
    public ObservableList<Double> myActiveTurtles(){
        return myActiveTurtles;
    }
    public void setWorkingTurtle(double id){
        myActiveTurtles.clear();
        myActiveTurtles.add(id);
    }
    public TurtleData getWorkingTurtle(){
        return myData.turtleData(myActiveTurtles.get(myActiveTurtles.size() - 1));
    }
    public double getWorkingID(){
        return myActiveTurtles.get(myActiveTurtles.size() - 1);
    }
    public GlobalData getData(){
        return myData;
    }
}
