package executables;
import visualizer.Visualizer;


public class ShowExecutable extends Executable {
  public ShowExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.show();
    return 1;
  }


}
