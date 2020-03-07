package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class SetBackgroundExecutable extends ExecutableSuperClass {
    private int myBackground;

    public SetBackgroundExecutable(){

    }

    public void addMove(int background){
        myBackground = background;
    }
    @Override
    public void execute(Visualizer visualizer) {

    }

    @Override
    public String getCommandName(String language) {
        return null;
    }
}
