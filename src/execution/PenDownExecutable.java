package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for PenDown command.
 */
public class PenDownExecutable extends ExecutableSuperClass {
  private static final String executableType = "PenDown";


  @Override
  public String getCommand() {
    return null;
  }

  @Override
  public Double[] getArgs() {
    return new Double[0];
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }


}
