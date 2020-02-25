package executables;
import visualizer.Visualizer;


public class XCorExecutable extends Executable {
  public XCorExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleX();
  }


}
