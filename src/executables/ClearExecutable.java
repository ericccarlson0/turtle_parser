package executables;

import static executables.SetXYExecutable.getDistanceTraveled;
import visualizer.Visualizer;


public class ClearExecutable extends Executable {
  public ClearExecutable(){
  }

  public double run(Visualizer visualizerObject){
    //TODO visualizerObject.clear();
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleX(0);
    visualizerObject.setTurtleY(0);
    return distanceTraveled;
  }
}