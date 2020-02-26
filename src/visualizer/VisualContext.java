package visualizer;

import execution.ExecutableSuperClass;

import java.util.List;

public class VisualContext {
    private Visualizer myVisualizer;
    private List<ExecutableSuperClass> myExecutableSuperClassQueue;

    public VisualContext(Visualizer visualizer, List<ExecutableSuperClass> queue){
        myVisualizer = visualizer;
        myExecutableSuperClassQueue = queue;
    }

    public Visualizer getVisualizer(){
        return myVisualizer;
    }
    public List<ExecutableSuperClass> getExecutableQueue(){
        return myExecutableSuperClassQueue;
    }
}
