package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Hide command.
 */
public class HideExecutable extends ExecutableSuperClass {
  private static final String executableType = "HideTurtle";

  private boolean myHide;

  public HideExecutable(boolean hide){
    myHide = hide;
  }

  @Override
  public String getCommand() {
    return "hide";
  }

  @Override
  public Double[] getArgs() {
    return new Double[]{myHide ? 0.0 : 1.0};
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }

}
