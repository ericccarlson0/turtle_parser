package executables;
import static executables.SetXYExecutable.getDistanceTraveled;
import visualizer.Visualizer;


public class HomeExecutable extends Executable {
  private final String executableType = "Home";
  public HomeExecutable(){ }
  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleX(0);
    visualizerObject.setTurtleY(0);
    return distanceTraveled;
  }


  public String getString() {
    return getExecutableName(executableType);
  }



}