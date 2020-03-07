package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.List;

public class SetShapeExecutable extends ExecutableSuperClass {
    private List<Integer> ids;
    private List<Integer> indexs;
    private String name;

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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
