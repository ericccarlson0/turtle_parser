package execution.newExecutables;

import execution.ExecutableSuperClass;

public class LeadTurtleExecutable extends ExecutableSuperClass {
  private static final String EXECUTABLE_TYPE = "LeadTurtle";
  private static final int ARGUMENT_SIZE = 5;

  public LeadTurtleExecutable() {
    super();
    argSize = ARGUMENT_SIZE;
  }
  @Override
  public String getCommand() { return "leadTurtle"; }

  @Override
  public String getString() {
    return getExecutableName(EXECUTABLE_TYPE);
  }
}
