package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class SetPaletteExecutable extends ExecutableSuperClass {
    private String name;
    public SetPaletteExecutable(double colorIndex, double red, double green, double blue) {
        super();
    }

    @Override
    public void execute(Visualizer visualizer) {

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
