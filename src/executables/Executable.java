package executables;

import Visualizer.Visualizer;

public abstract class Executable {

  public Executable(String... args){ }

  public abstract double run(Visualizer vis);
}

