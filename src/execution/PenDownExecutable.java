package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for PenDown command.
 */
public class PenDownExecutable extends ExecutableSuperClass {
  private String name;

  @Override
  public void execute(Visualizer visualizer) {

  }

  public void addMove(int id, boolean penDown){

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
