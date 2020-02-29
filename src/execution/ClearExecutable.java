package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Clear command.
 */
public class ClearExecutable extends ExecutableSuperClass {
  private static final String executableType = "ClearScreen";

  private double myStartX;
  private double myStartY;

  public ClearExecutable(double startX, double startY){
    myStartX = startX;
    myStartY = startY;
  }
  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Distance traveled.
   */
  public double run(Visualizer visualizerObject){
    double distanceTraveled = Math.sqrt(Math.pow(myStartX,2) + Math.pow(myStartY,2));
    visualizerObject.clearScreen();
    return distanceTraveled;
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }
}