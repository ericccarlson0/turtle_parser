package execution;
import javafx.beans.property.StringProperty;
import parserModel.TurtleContext;

/**
 * @Author: Cemal Yagcioglu
 * This Interface offers implementation of
 * Executable command objects. The executable
 * commands are the 'actionable' commands that consist
 * both the Turtle movement and Turtle queries. A new
 * executable can be added using this interface.
 */
public interface Executable {

  void execute(TurtleContext context);

  void updateLanguage(String language);
  StringProperty command();
}