package execution;

import execution.Executable;
import execution.ExecutableSuperClass;
import parserModel.TurtleContext;
import visualizer.Visualizer;

public class SetPenColorExecutable extends ExecutableSuperClass {
    private String name;

    @Override
    public void execute(Visualizer visualizer) {

    }

    public void addMove(int id, int tag){

    }

    @Override
    public String getCommandName(String language) {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
