package execution;

import visualizer.Visualizer;


public class PenDownPExecutable extends ExecutableSuperClass {
  private final String executableType = "IsPenDown";

  public PenDownPExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtlePen();
  }

  public String getString() {
    return getExecutableName(executableType);
  }

}
