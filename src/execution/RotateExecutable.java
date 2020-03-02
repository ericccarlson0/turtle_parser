package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for RightTurn command.
 */
public class RotateExecutable extends ExecutableSuperClass {
  private static final String executableType = "Right";

  private double myStartHeading;
  private double myEndHeading;

  /**
   * Constructs the executable.
   */
  public RotateExecutable(double startHeading, double endHeading){
    myStartHeading = startHeading;
    myEndHeading = endHeading;
  }

  @Override
  public String getCommand() {
    return "setTurtleAngle";
  }

  @Override
  public Double[] getArgs() {
    return new Double[]{myStartHeading, myEndHeading};
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" "+(myEndHeading-myStartHeading);
  }


}
