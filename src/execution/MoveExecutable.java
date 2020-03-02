package execution;

import visualizer.Visualizer;

import java.util.List;

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

  @Override
  public String getCommand() {
    return "setPosition";
  }

  @Override
  public Double[] getArgs() {
    return new Double[]{myStartX, myStartY, myEndX, myEndY};
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" ";

  }
}
