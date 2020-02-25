package executables;
import Visualizer.Visualizer;


public class showTurtleExecutable extends Executable {
  public showTurtleExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.show();
    return 1;
  }


}
