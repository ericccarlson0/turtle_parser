package executables;
import static executables.setxyExecutable.getDistanceTraveled;
import Visualizer.Visualizer;


public class homeExecutable extends Executable {

  public homeExecutable(){ }

  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleX(0);
    visualizerObject.setTurtleY(0);
    return distanceTraveled;
  }


}
