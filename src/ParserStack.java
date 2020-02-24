import commands.Command;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParserStack {
  private List<Command> commandStack;
  private int stackSize = 0;

  /**
   * Create a new stack to execute commands;
   */
  public ParserStack() {
    this.commandStack = new ArrayList<>();
    this.stackSize = 0;
  }

  /**
   * Create a stack to execute commands, with commands to initialize it with.
   * @param commands
   */
  public ParserStack(List<Command> commands) {
    this.commandStack = List.copyOf(commands);
    this.stackSize = commands.size();
  }

  public void pushCommand(Command c) {
    commandStack.add(c);
    stackSize++;
  }

  /**
   * This should ONLY be called if you can be 100% sure that there is a command.
   */
  public Command popCommand() {
    Command c = commandStack.get(stackSize-1);
    c.doCommand();
    stackSize--;
    return c;
  }

  /**
   * The entire stack is traversed and the commands are executed.
   */
  public void execute() {
    while (stackSize > 0) {
      popCommand();
    }
  }
}
