package execution;

import visualizer.Visualizer;

public class ShowingPExecutable extends ExecutableSuperClass {
  private final String executableType = "IsShowing";
  public ShowingPExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getShowing();
  }


  public String getString() {
    return getExecutableName(executableType);
  }

}
