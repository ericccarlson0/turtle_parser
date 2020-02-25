package executables;
import Visualizer.Visualizer;


public class PenDownExecutable extends Executable {
  public PenDownExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(true);
    return 1;
  }

  @Override
  public String getString() {
    return null;
  }


}
