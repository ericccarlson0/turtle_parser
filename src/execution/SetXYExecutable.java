package execution;

import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Setxy command.
 */
public class SetXYExecutable extends ExecutableSuperClass {
  private static final String executableType = "SetPosition";
  private double xSet;
  private double ySet;

  /**
   * Constructs the executable.
   * @param xInput
   * @param yInput
   */
  public SetXYExecutable(double xInput, double yInput){
    xSet=xInput;
    ySet=yInput;
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Distance traveled.
   */
  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject, xSet, ySet);
    visualizerObject.setTurtleGameX(xSet);
    visualizerObject.setTurtleGameY(ySet);
    visualizerObject.draw();
    return distanceTraveled;
  }

  /**
   * Helper method for subclasses that wants to
   * calculate the distance traveled.
   * @param visualizerObject
   * @return Distance traveled.
   */
  public static double getDistanceTraveled(Visualizer visualizerObject, double xSet, double ySet) {
    double currentXPosition = visualizerObject.getTurtleGameX();
    double currentYPosition = visualizerObject.getTurtleGameY();
    double xDistance = xSet - currentXPosition;
    double yDistance = ySet - currentYPosition;
    return Math.sqrt(Math.pow(xDistance,2)+Math.pow(yDistance,2));
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" "+xSet+" "+ySet;
  }


}
