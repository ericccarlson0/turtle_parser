package visualizer;

import execution.Executable;

import java.util.List;

public class VisualContext {
    private Visualizer myVisualizer;
    private List<Executable> myExecutableQueue;

    public VisualContext(Visualizer visualizer, List<Executable> queue){
        myVisualizer = visualizer;
        myExecutableQueue = queue;
    }

    public Visualizer getVisualizer(){
        return myVisualizer;
    }
    public List<Executable> getExecutableQueue(){
        return myExecutableQueue;
    }
}
