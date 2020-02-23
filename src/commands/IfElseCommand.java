package commands;

import commands.Command.CommandType;
import java.util.List;

public class IfElseCommand {

  protected List<Command> ifCommands;
  protected List<Command> elseCommands;
  protected List<Command> conditions;
  CommandType type = CommandType.COMPOUND;

  public IfElseCommand(List<Command> conditions, List<Command> ifCommands, List<Command> elseCommands) {
    this.ifCommands = ifCommands;
    this.elseCommands = elseCommands;
    this.conditions = conditions;
  }

  public int doCommand() {
    int commandReturn = 0;
    int conditionReturn = 0;
    for (Command condition : conditions) {
      conditionReturn = condition.doCommand();
    }
    if (conditionReturn == 0) {
      for (Command c : ifCommands) {
        commandReturn = c.doCommand();
      }
    } else {
      for (Command c : elseCommands) {
        commandReturn = c.doCommand();
      }
    }
    return commandReturn;
  }
}
