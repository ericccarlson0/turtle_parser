package execution;
import static execution.SetXYExecutable.getDistanceTraveled;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Home command.
 */
public class HomeExecutable extends ExecutableSuperClass {
  private final String executableType = "Home";

  /**
   * Constructs the executable.
   */
  public HomeExecutable(){ }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Distance traveled.
   */
  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleGameX(0);
    visualizerObject.setTurtleGameY(0);
    visualizerObject.setTurtleAngle(0);
    return distanceTraveled;
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType);
  }



}
