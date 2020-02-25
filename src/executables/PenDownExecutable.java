package executables;
import visualizer.Visualizer;


public class PenDownExecutable extends Executable {
  public PenDownExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(true);
    return 1;
  }


}
