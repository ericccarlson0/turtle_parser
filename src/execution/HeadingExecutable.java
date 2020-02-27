package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for HeadingExecutable command.
 */
public class HeadingExecutable extends ExecutableSuperClass {
  private final String executableType = "Heading";
  private double myHeading;

  /**
   * Constructs the executable.
   */
  public HeadingExecutable() {
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return Turtle's angle.
   */
  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleAngle();
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType);
  }

}
