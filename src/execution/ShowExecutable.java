package execution;

import visualizer.Visualizer;


public class ShowExecutable extends ExecutableSuperClass {
  private final String executableType = "ShowTurtle";

  public ShowExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.show();
    return 1;
  }

  public String getString() {
    return getExecutableName(executableType);

  }

}
