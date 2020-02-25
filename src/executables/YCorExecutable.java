package executables;
import visualizer.Visualizer;


public class YCorExecutable extends Executable {
  public YCorExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleY();
  }


}
