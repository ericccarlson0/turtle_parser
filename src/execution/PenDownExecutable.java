package execution;

import visualizer.Visualizer;

public class PenDownExecutable extends ExecutableSuperClass {
  private final String executableType = "PenDown";
  public PenDownExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(true);
    return 1;
  }

  public String getString(){
    return getExecutableName(executableType);
  }


}
