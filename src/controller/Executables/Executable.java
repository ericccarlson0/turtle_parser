package Controller.Executables;

public abstract class Executable {
  public String[] parameters;
  //defined parameters
  public Executable(String... args){
    parameters = args;
  }

  abstract protected void run();

}

