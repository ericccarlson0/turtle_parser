import executables.Executable;
import java.util.ArrayList;
import java.util.List;

public class ExecutableQueue {
  private List<Executable> commandStack;
  private int stackSize = 0;

  /**
   * Create a new stack to execute commands;
   */
  public ExecutableQueue() {
    this.commandStack = new ArrayList<>();
    this.stackSize = 0;
  }

  /**
   * Create a stack to execute commands, with commands to initialize it with.
   * @param commands
   */
  public ExecutableQueue(List<Executable> commands) {
    this.commandStack = List.copyOf(commands);
    this.stackSize = commands.size();
  }

  public void pushCommand(Executable c) {
    commandStack.add(c);
    stackSize++;
  }

  /**
   * This should ONLY be called if you can be 100% sure that there is a command.
   */
  public Executable popCommand() {
    Executable c = commandStack.get(stackSize-1);
    c.run();
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
