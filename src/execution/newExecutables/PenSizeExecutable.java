package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class PenSizeExecutable extends ExecutableSuperClass {
    private double myStrokeWidth;
    private String name;

    public PenSizeExecutable(double strokeWidth){
        myStrokeWidth = strokeWidth;
    }

    @Override
    public void execute(Visualizer visualizer) {
        visualizer.setPenSize(myStrokeWidth);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
