package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Towards command.
 */
public class TowardsExecutable extends ExecutableSuperClass {
  private final String executableType = "SetTowards";
  private double xHeading;
  private double yHeading;

  /**
   * Constructs the executable.
   * @param xInput
   * @param yInput
   */
  public TowardsExecutable(double xInput, double yInput){
    xHeading=xInput;
    yHeading=yInput;
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Angle change.
   */
  public double run(Visualizer visualizerObject){
    double currentXPosition = visualizerObject.getTurtleGameX();
    double currentYPosition = 500 - visualizerObject.getTurtleGameY();
    System.out.println(currentXPosition);
    System.out.println(currentYPosition);
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle;
    if(xHeading-currentXPosition==0 && yHeading-currentYPosition==0){
      newAngle = currentAngle;
    }
    else {
      newAngle = -Math
          .toDegrees(Math.atan((yHeading - currentYPosition) / (xHeading - currentXPosition)));
    }
    if(xHeading-currentXPosition<0){
      newAngle+=180;
    }
    visualizerObject.setTurtleAngle(newAngle);
    return (newAngle-currentAngle)%360;
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType) + " " + xHeading + " " + yHeading;
  }


}
