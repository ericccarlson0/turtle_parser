package executables;
import Visualizer.Visualizer;


public class HideExecutable extends Executable {
  public HideExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.hide();
    return 0;
  }

  @Override
  public String getString() {
    return null;
  }


}
