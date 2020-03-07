package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class SetBackgroundExecutable extends ExecutableSuperClass {
    private int myBackground;
    private String name;

    public SetBackgroundExecutable(){

    }

    public void addMove(int background){
        myBackground = background;
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
