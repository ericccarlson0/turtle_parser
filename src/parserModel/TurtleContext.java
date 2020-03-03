package parserModel;

import execution.Executable;
import execution.ExecutableSuperClass;
import visualizer.Visualizer;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TurtleContext{
    private Queue<Executable> myExecutableSuperClassQueue;
    private GlobalData myData;
    private List<Double> myActiveTurtles;

    public TurtleContext(){
        myActiveTurtles = new ArrayList<>();
        myData = new GlobalData();
        myExecutableSuperClassQueue = new LinkedList<>();
    }
    public Iterator<Executable> getExecutables(){
        return myExecutableSuperClassQueue.iterator();
    }

    public void resetQueue(){
        myExecutableSuperClassQueue = new LinkedList<>();
    }
    public void addToQueue(Executable ex){
        myExecutableSuperClassQueue.add(ex);
    }
    public List<Double> getActiveTurtles(){
        return myActiveTurtles;
    }
    public void addActiveTurtles(Collection<Double> ids){
        myActiveTurtles.addAll(ids);
    }
    public void clearActiveTurtles(){
        myActiveTurtles.clear();
    }
    public GlobalData getData(){
        return myData;
    }
}
