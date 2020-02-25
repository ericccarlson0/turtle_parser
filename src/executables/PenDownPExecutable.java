package executables;
import visualizer.Visualizer;


public class PenDownPExecutable extends Executable {
  public PenDownPExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getPenDown();
  }


}
