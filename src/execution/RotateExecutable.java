package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for RightTurn command.
 */
public class RotateExecutable extends ExecutableSuperClass {
  private static final String executableType = "Right";
  private static final int ARGUMENT_SIZE = 3; //id, startheading, endHeading

  public RotateExecutable(){
    super();
    argSize = ARGUMENT_SIZE;
  }

  @Override
  public String getCommand() {
    return "setTurtleAngle";
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }


}
