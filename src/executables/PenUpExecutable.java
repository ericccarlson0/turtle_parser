package executables;
import Visualizer.Visualizer;


public class PenUpExecutable extends Executable {
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
