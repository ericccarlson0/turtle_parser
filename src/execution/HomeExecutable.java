package execution;
import static execution.SetXYExecutable.getDistanceTraveled;
import visualizer.Visualizer;


public class HomeExecutable extends Executable {
  private final String executableType = "Home";
  public HomeExecutable(){ }
  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleGameX(0);
    visualizerObject.setTurtleGameY(0);
    visualizerObject.setTurtleAngle(0);
    return distanceTraveled;
  }


  public String getString() {
    return getExecutableName(executableType);
  }



}
