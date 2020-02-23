package commands;

public abstract class Command {
  enum CommandType {
    PRIMITIVE, COMPOUND, MATH, BOOLEAN, OTHER
  }

  protected CommandType type;
  public abstract int doCommand();
}
