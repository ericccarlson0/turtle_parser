package execution;
import static execution.SetXYExecutable.getDistanceTraveled;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Clear command.
 */
public class ClearExecutable extends ExecutableSuperClass {
  private final String executableType = "ClearScreen";

  /**
   * Constructs the executable.
   */
  public ClearExecutable(){
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Distance traveled.
   */
  public double run(visualizer.Visualizer visualizerObject){
    double distanceTraveled =  getDistanceTraveled(visualizerObject, 0, 0);
    visualizerObject.clearScreen();
    return distanceTraveled;
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }
}