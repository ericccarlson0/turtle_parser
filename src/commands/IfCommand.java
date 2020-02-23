package commands;

import java.util.List;

public class IfCommand extends Command {
  protected List<Command> commands;
  protected List<Command> conditions;
  CommandType type = CommandType.COMPOUND;

  public IfCommand(List<Command> conditions, List<Command> commands) {
    this.commands = commands;
    this.conditions = conditions;
  }

  public int doCommand() {
    int commandReturn = 0;
    int conditionReturn = 0;
    for (Command condition : conditions) {
      conditionReturn = condition.doCommand();
    }
    if (conditionReturn == 0) {
      for (Command c : commands) {
        commandReturn = c.doCommand();
      }
    }
    return commandReturn;
  }
}
