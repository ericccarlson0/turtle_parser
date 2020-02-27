package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Hide command.
 */
public class HideExecutable extends ExecutableSuperClass {
  private static final String executableType = "HideTurtle";

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return 0.
   */
  public double run(Visualizer visualizerObject){
    visualizerObject.hide();
    return 0;
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }

}
