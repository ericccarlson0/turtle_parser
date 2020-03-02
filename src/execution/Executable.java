package execution;
import visualizer.Visualizer;

import java.util.List;

/**
 * @Author: Cemal Yagcioglu
 * This Interface offers implementation of
 * Executable command objects. The executable
 * commands are the 'actionable' commands that consist
 * both the Turtle movement and Turtle queries. A new
 * executable can be added using this interface.
 */
public interface Executable {

  String getCommand();

  Double[] getArgs();

  /**
   * Returns the preset string value for the executable for
   * the executable history pane.
   * @return Defined String Value for the executable.
   */
  String getString();

  /**
   * Defines relationship between executable type and the string value
   * for the executable history pane.
   * At this stage of the development, this method supports
   * the multi-language implementation by returning
   * executable's name in the chosen language.
   * @param executableType
   * @return Executable name in the chosen language.
   */
  String getExecutableName(String executableType);
}
