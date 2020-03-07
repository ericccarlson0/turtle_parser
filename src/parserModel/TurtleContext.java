package parserModel;

import execution.Executable;
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

    public TurtleContext() {
        myActiveTurtles = FXCollections.observableArrayList();
        myData = new GlobalData();
        myExecutableQueue = new LinkedList<>();
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
    public void clearActiveTurtles(){
        myActiveTurtles.clear();
    }
    public void addActiveTurtles(Collection<Double> ids){
        myActiveTurtles.addAll(ids);
    }
    public ObservableList<Double> myActiveTurtles(){
        return myActiveTurtles;
    }
    public GlobalData getData(){
        return myData;
    }
}
