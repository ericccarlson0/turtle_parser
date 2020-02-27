package execution;

import visualizer.Visualizer;


public class PenUpExecutable extends ExecutableSuperClass {
  private final String executableType = "PenUp";
  public PenUpExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(false);
    return 0;
  }

  public String getString(){
    return getExecutableName(executableType);

  }


}
