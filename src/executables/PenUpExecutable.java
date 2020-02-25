package executables;
import visualizer.Visualizer;


public class PenUpExecutable extends Executable {
  public PenUpExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(false);
    return 0;
  }


}
