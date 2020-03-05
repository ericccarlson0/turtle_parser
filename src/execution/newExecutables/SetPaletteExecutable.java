package execution.newExecutables;

import execution.Executable;
import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class SetPaletteExecutable extends ExecutableSuperClass {

    public SetPaletteExecutable(double colorIndex, double red, double green, double blue) {
        super();
    }

    @Override
    public void execute(Visualizer visualizer) {

    }

    @Override
    public String getCommandName(String language) {
        return null;
    }
}
