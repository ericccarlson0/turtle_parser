package execution;

public class ClearExecutable extends Executable {
  private final String executableType = "ClearScreen";
  public ClearExecutable(){
  }

  public double run(visualizer.Visualizer visualizerObject){
    // TODO visualizerObject.clear();
    double distanceTraveled = 0.0; // getDistanceTraveled(visualizerObject, 0, 0);
    visualizerObject.setTurtleX(0);
    visualizerObject.setTurtleY(0);
    return distanceTraveled;
  }

  public String getString(){
    return getExecutableName(executableType);
  }
}