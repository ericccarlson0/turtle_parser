package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Clear command.
 */
public class ClearExecutable extends ExecutableSuperClass {
  private static final String executableType = "ClearScreen";
  private static final int ARGUMENT_SIZE = 1;

  public ClearExecutable(){
    super();
    argSize = ARGUMENT_SIZE;
  }

  @Override
  public String getCommand() {
    return "clearScreen"; //TODO
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }
}