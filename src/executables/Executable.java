package executables;

public abstract class Executable {
  public String[] parameters;
  //defined parameters
  public Executable(String... args){
    parameters = args;
  }

  public abstract void run();
}

