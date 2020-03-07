package execution;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Hide command.
 */
public class HideExecutable implements Executable {

  private List<Integer> myIDs;
  private List<Boolean> myHides;
  private String name;

  public HideExecutable(){
    myIDs = new ArrayList<>();
    myHides = new ArrayList<>();
  }

  public void addMove(int id, boolean hide){
    myIDs.add(id);
    myHides.add(hide);
  }

  @Override
  public void execute(Visualizer visualizer) {
    visualizer.hide(new ArrayList<>(myIDs), new ArrayList<>(myHides));
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
