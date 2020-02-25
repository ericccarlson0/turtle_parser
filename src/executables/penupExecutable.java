package executables;
import Visualizer.Visualizer;


public class penupExecutable extends Executable {
  public penupExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(false);
    return 0;
  }


}
