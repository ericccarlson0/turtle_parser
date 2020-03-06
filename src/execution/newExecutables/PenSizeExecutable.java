package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class PenSizeExecutable extends ExecutableSuperClass {
    private double myStrokeWidth;

    public PenSizeExecutable(double strokeWidth){
        myStrokeWidth = strokeWidth;
    }

    @Override
    public void execute(Visualizer visualizer) {
        visualizer.setPenSize(myStrokeWidth);
    }

    @Override
    public String getCommandName(String language) {
        return null;
    }
}
