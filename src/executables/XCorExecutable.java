package executables;
import Visualizer.Visualizer;


public class XCorExecutable extends Executable {
  public XCorExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleX();
  }


}
