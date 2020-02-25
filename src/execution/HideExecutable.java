package execution;
import Visualizer.Visualizer;


public class HideExecutable extends Executable {
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
