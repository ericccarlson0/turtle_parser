package executables;
import Visualizer.Visualizer;


public class ShowExecutable extends Executable {
  public ShowExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.show();
    return 1;
  }

  public String getString(){
    return getExecutableName(executableType);
  }


}
