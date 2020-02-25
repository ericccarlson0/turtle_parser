package execution;
import Visualizer.Visualizer;


public class PenUpExecutable extends Executable {
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
