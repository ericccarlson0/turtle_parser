package parserModel;

import execution.Executable;
import execution.ExecutableSuperClass;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.List;

public class TurtleContext {
    private List<Executable> myExecutableSuperClassQueue;

    public TurtleContext(){
        myExecutableSuperClassQueue = new ArrayList<>();
    }
    public List<Executable> getExecutableQueue(){
        return myExecutableSuperClassQueue;
    }
}
