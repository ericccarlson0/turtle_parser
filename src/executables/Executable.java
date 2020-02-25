package executables;

import Visualizer.Visualizer;

public abstract class Executable {

  public Executable(String... args){
  }

<<<<<<< HEAD:src/executables/Executable.java
  public abstract void run();
=======
  abstract protected double run(Visualizer visualizerObject);
>>>>>>> cy111:src/controller/Executables/Executable.java
}

