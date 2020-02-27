package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for PenDown command.
 */
public class PenDownExecutable extends ExecutableSuperClass {
  private static final String executableType = "PenDown";

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return 1.
   */
  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(true);
    return 1;
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }


}
