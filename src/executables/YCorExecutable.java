package executables;
import visualizer.Visualizer;


public class YCorExecutable extends Executable {
  private final String executableType = "YCoordinate";
  public YCorExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleY();
  }


  public String getString() {
    return getExecutableName(executableType);
  }


}
