package execution;

import visualizer.Visualizer;
/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Forward command.
 */
public class ForwardExecutable extends ExecutableSuperClass {
  private static final String executableType = "Forward";
  private double distance;
  /**
   * Constructs the executable.
   * @param distanceUnit
   */
  public ForwardExecutable(double distanceUnit){
    distance = distanceUnit;
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Distance input.
   */
  public double run(Visualizer visualizerObject){
    for(int i=0; i<distance; i++){
      double currentXPosition = visualizerObject.getTurtleX();
      double currentYPosition = visualizerObject.getTurtleY();
      double currentAngle = visualizerObject.getTurtleAngle();
      double newXPosition = currentXPosition + Math.cos(Math.toRadians(currentAngle))*1;
      double newYPosition = currentYPosition + Math.sin(Math.toRadians(currentAngle))*1;
      visualizerObject.setTurtleX(newXPosition);
      visualizerObject.setTurtleY(newYPosition);
      visualizerObject.draw();
    }
    return distance;
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" "+distance;
  }


}
