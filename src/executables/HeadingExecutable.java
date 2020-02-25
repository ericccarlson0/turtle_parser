package executables;
import Visualizer.Visualizer;


public class HeadingExecutable extends Executable {
  private final String executableType = "Backward";
  public HeadingExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleAngle();
  }

  public String getString(){
    return getExecutableName(executableType);
  }

}
