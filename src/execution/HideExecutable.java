package execution;

import visualizer.Visualizer;


public class HideExecutable extends ExecutableSuperClass {
  private final String executableType = "HideTurtle";

  public HideExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.hide();
    return 0;
  }


  public String getString(){
    return getExecutableName(executableType);
  }

}
