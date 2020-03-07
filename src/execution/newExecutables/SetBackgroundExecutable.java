package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class SetBackgroundExecutable extends ExecutableSuperClass {
    private String name;

    public SetBackgroundExecutable(int id){

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
