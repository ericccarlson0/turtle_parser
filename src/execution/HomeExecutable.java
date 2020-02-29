package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Home command.
 */
public class HomeExecutable extends ExecutableSuperClass {
  private static final String executableType = "Home";

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Distance traveled.
   */
  public double run(Visualizer visualizerObject){
    //visualizerObject.set
    //visualizerObject.setTurtleAngle(0);
    //return distanceTraveled;
    return 0.0; //FIXME
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType);
  }



}
