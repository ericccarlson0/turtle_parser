package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for PenDown command.
 */
public class PenDownExecutable extends ExecutableSuperClass {
  private static final String executableType = "PenDown";
  private static final int ARGUMENT_SIZE = 2; //id, penDown?

  public PenDownExecutable(){
    super();
    argSize = ARGUMENT_SIZE;
  }

  @Override
  public String getCommand() {
    return null;
  } //TODO

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }


}
