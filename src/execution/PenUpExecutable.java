package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for PenUp command.
 */
public class PenUpExecutable extends ExecutableSuperClass {
  private final String executableType = "PenUp";

  /**
   * Constructs the executable.
   */
  public PenUpExecutable(){
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return 0.
   */
  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(false);
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
