package executables;
import Visualizer.Visualizer;


public class ShowExecutable extends Executable {
  private final String executableType = "ShowTurtles";

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
