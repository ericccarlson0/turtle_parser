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

  @Override
  public String getCommand() {
    return "clearScreen"; //TODO
  }

  @Override
  public Double[] getArgs() {
    return new Double[0];
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }
}