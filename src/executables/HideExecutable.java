package executables;
import visualizer.Visualizer;


public class HideExecutable extends Executable {
  public HideExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.hide();
    return 0;
  }


}
