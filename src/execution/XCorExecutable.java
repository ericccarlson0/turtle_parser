package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for XCor command.
 */
public class XCorExecutable extends ExecutableSuperClass {
  private final String executableType = "XCoordinate";

  /**
   * Constructs the executable.
   */
  public XCorExecutable(){
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Turtle's X coordinate.
   */
  public double run(Visualizer visualizerObject){
    visualizerObject.addUserInput(Double.toString(visualizerObject.getTurtleGameX()));//
    return visualizerObject.getTurtleGameX();
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType);
  }


}
