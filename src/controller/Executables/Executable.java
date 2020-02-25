package controller.Executables;

import Visualizer.Visualizer;

public abstract class Executable {

  public Executable(String... args){
  }

  abstract protected double run(Visualizer visualizerObject);
}

