package execution;
import javafx.beans.property.StringProperty;
import parserModel.TurtleContext;
import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This Interface offers implementation of
 * Executable command objects. The executable
 * commands are the 'actionable' commands that consist
 * both the Turtle movement and Turtle queries. A new
 * executable can be added using this interface.
 */
public interface Executable {

  void execute(Visualizer visualizer);

  String getCommandName(String language);
}