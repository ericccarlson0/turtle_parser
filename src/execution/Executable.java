package execution;

import visualizer.Visualizer;

/**
 * @Author: Cemal Yagcioglu
 * This Interface offers implementation ofExecutable command objects. The executable commands are
 * the 'actionable' commands that consist both the Turtle movement and Turtle queries. A new
 * executable can be added using this interface.
 */
public interface Executable {

  void execute(Visualizer visualizer);

  String getCommandName(String language);
}