package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for LeftTurn command.
 */
public class LTurnExecutable extends ExecutableSuperClass {
  private final String executableType = "Left";
  private double angle;

  /**
   * Constructs the executable.
   * @param angleInput
   */
  public LTurnExecutable(double angleInput){
    angle = angleInput;
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Angle input in degrees.
   */
  public double run(Visualizer visualizerObject){
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = (currentAngle-angle)%360;
    visualizerObject.setTurtleAngle(newAngle);
    return angle;
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" "+angle;
  }
  
}
