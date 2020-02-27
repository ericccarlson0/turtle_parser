package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for SetHeading command.
 */
public class SetHeadingExecutable extends ExecutableSuperClass {
  private final String executableType = "SetHeading";
  private double angle;

  /**
   * Constructs the executable.
   * @param angleInput
   */
  public SetHeadingExecutable(double angleInput) {
    angle = angleInput;
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Angle's change in degrees.
   */
  public double run(Visualizer visualizerObject) {
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = angle%360;
    double radiansMoved = newAngle-currentAngle;
    visualizerObject.setTurtleAngle(-newAngle); //TODO why negative again
    return Math.toDegrees(radiansMoved);
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" "+angle;
  }
}


