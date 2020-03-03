package execution;

import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Backward command.
 */
public class MoveExecutable extends ExecutableSuperClass {
  private static final String executableType = "Backward";
  private static final int ARGUMENT_SIZE = 5; //id, startX, startY, endX, endY

  public MoveExecutable(){
    super();
    argSize = ARGUMENT_SIZE;
  }

  @Override
  public String getCommand() {
    return "setPosition";
  }

  /**
   * Returns the string value to be shown on the executable history.
   * @return Executable Name.
   */
  public String getString(){
    return getExecutableName(executableType)+" ";

  }
}
