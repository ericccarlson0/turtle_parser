package executables;
import visualizer.Visualizer;


public class ShowingPExecutable extends Executable {
  public ShowingPExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getShowing();
  }


}
