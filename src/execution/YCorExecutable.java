package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for YCor command.
 */
public class YCorExecutable extends ExecutableSuperClass {
  private final String executableType = "YCoordinate";

  /**
   * Constructs the executable.
   */
  public YCorExecutable(){
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Turtle's Y coordinate.
   */
  public double run(Visualizer visualizerObject){
    visualizerObject.addUserInput(Double.toString(visualizerObject.getTurtleGameY()));
    return visualizerObject.getTurtleGameY();
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType);
  }


}
