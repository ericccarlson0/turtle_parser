package executables;
import Visualizer.Visualizer;


public class YCorExecutable extends Executable {
  public YCorExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleY();
  }

  @Override
  public String getString() {
    return null;
  }


}
