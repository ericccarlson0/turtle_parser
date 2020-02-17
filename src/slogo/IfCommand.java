package slogo;

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
    int ret = 0;
    int condReturn = 0;
    for (Command cond : conditions) {
      condReturn = cond.doCommand();
    }
    if (condReturn == 0) {
      for (Command comm : commands) {
        ret = comm.doCommand();
      }
    }
    return ret;
  }
}
