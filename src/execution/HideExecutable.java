package execution;
import visualizer.Visualizer;

import java.util.Collection;
import java.util.List;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Hide command.
 */
public class HideExecutable extends ExecutableSuperClass {
  private static final String executableType = "HideTurtle";
  private static final int ARGUMENT_SIZE = 2; //id, hide?

  public HideExecutable(){
    super();
    argSize = ARGUMENT_SIZE;
  }

  @Override
  public String getCommand() {
    return "hide";
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }

}
