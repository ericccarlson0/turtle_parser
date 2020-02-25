package executables;
import Visualizer.Visualizer;


public class HeadingExecutable extends Executable {
  public HeadingExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleAngle();
  }

  @Override
  public String getString() {
    return null;
  }


}
