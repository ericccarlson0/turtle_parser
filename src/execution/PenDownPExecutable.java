package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for PenDownP command.
 */
public class PenDownPExecutable extends ExecutableSuperClass {
  private static final String executableType = "IsPenDown";

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return 1 if turtle pen is down and 0 else.
   */
  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtlePen();
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType);
  }

}
