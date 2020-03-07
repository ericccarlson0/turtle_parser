package execution;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;
import java.util.ArrayList;
import java.util.List;

public class SetPaletteExecutable extends ExecutableSuperClass {
    private String myName;

    private List<Integer> myIDs;
    private List<Double> myReds;
    private List<Double> myGreens;
    private List<Double> myBlues;

    public SetPaletteExecutable() {
        super();
        myIDs = new ArrayList<>();
        myReds = new ArrayList<>();
        myGreens = new ArrayList<>();
        myBlues = new ArrayList<>();
    }

    @Override
    public void execute(Visualizer visualizer) {
        visualizer.setPalette(myIDs, myReds, myGreens, myBlues);
    }
    public void addMove(int id, double red, double green, double blue){
        myIDs.add(id);
        myReds.add(red);
        myGreens.add(green);
        myBlues.add(blue);
    }

    @Override
    public String getName() {
        return myName;
    }
    @Override
    public void setName(String name) {
        this.myName = name;
    }
}
