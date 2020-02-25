package executables;
import visualizer.Visualizer;


public class HeadingExecutable extends Executable {
  public HeadingExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleAngle();
  }


}
