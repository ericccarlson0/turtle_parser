package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for ShowP command.
 */
public class ShowingPExecutable extends ExecutableSuperClass {
  private static final String executableType = "IsShowing";

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return 1 if turtle is showing and 0 else.
   */
  public double run(Visualizer visualizerObject){
    return visualizerObject.getShowing();
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType);
  }

}
