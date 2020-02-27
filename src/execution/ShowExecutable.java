package execution;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Show command.
 */
public class ShowExecutable extends ExecutableSuperClass {
  private final String executableType = "ShowTurtle";

  /**
   * Constructs the executable.s
   */
  public ShowExecutable(){
  }

  /**
   * Runs the executable.
   * @param visualizerObject
   * @return 1.
   */
  public double run(Visualizer visualizerObject){
    visualizerObject.show();
    return 1;
  }
  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString() {
    return getExecutableName(executableType);

  }

}
