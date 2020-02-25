package controller.Executables;
import Visualizer.Visualizer;

public class hideTurtleExecutable extends Executable {
  public hideTurtleExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.hide();
    return 0;
  }


}
