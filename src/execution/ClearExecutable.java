package execution;
import visualizer.Visualizer;

import java.util.Collection;
import java.util.HashSet;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Clear command.
 */
public class ClearExecutable implements Executable {
  private static final String NAME = "ClearScreen";

  private Collection<Integer> myIDs;

  public ClearExecutable(){
    myIDs = new HashSet<>();
  }

  public void addMove(int id){
    myIDs.add(id);
  }

  @Override
  public void execute(Visualizer visualizer) {
    visualizer.clearScreen(new HashSet<>(myIDs));
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public void setName(String name) {
    //TODO?
  }
}