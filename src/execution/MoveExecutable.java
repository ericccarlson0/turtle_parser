package execution;

import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Backward command.
 */
public class MoveExecutable extends ExecutableSuperClass {
  private static final String executableType = "Backward";

  private double myStartX;
  private double myStartY;
  private double myEndX;
  private double myEndY;

  /**
   * Constructs the executable.
   */
  public MoveExecutable(double startX, double startY, double endX, double endY){
    myStartX = startX;
    myStartY = startY;
    myEndX = endX;
    myEndY = endY;
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Distance input.
   */
  public double run(Visualizer visualizerObject){
    double distance = Math.sqrt(Math.pow(myEndX  - myStartX, 2) + Math.pow(myStartY - myEndY, 2));
    visualizerObject.setPosition(myStartX, myStartY, myEndX, myEndY);
    return distance;
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" ";

  }
}
