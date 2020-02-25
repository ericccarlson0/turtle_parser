package executables;
import static executables.SetXYExecutable.getDistanceTraveled;
import Visualizer.Visualizer;


public class HomeExecutable extends Executable {

  public HomeExecutable(){ }

  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleX(0);
    visualizerObject.setTurtleY(0);
    return distanceTraveled;
  }

  @Override
  public String getString() {
    return null;
  }


}
