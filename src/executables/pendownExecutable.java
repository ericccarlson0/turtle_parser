package executables;
import Visualizer.Visualizer;


public class pendownExecutable extends Executable {
  public pendownExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(true);
    return 1;
  }


}
