package execution.newExecutables;

import execution.Executable;
import execution.ExecutableSuperClass;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.List;

public class SetShapeExecutable extends ExecutableSuperClass {
    private List<Integer> ids;
    private List<Integer> indexs;

    public SetShapeExecutable(){
        ids = new ArrayList<>();
        indexs = new ArrayList<>();
    }

    @Override
    public void execute(Visualizer visualizer) {

    }

    public void addMove(int id, int index){
        ids.add(id);
        indexs.add(index);
    }


    @Override
    public String getCommandName(String language) {
        return null;
    }
}
