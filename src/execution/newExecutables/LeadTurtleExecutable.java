package execution.newExecutables;

import execution.ExecutableSuperClass;
import visualizer.Visualizer;

public class LeadTurtleExecutable extends ExecutableSuperClass {
  private static final String EXECUTABLE_TYPE = "LeadTurtle";
  private static final int ARGUMENT_SIZE = 5;

  public LeadTurtleExecutable() {
    super();
    //argSize = ARGUMENT_SIZE;
  }

  public String getCommand() { return "leadTurtle"; }
  
  public String getString() {
    return getExecutableName(EXECUTABLE_TYPE);
  }

  @Override
  public void execute(Visualizer visualizer) {

  }

  @Override
  public String getCommandName(String language) {
    return null;
  }
}
