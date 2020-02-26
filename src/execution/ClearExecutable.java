package execution;

import static execution.SetXYExecutable.getDistanceTraveled;

public class ClearExecutable extends Executable {
  private final String executableType = "ClearScreen";
  public ClearExecutable(){
  }

  public double run(visualizer.Visualizer visualizerObject){
    double distanceTraveled =  getDistanceTraveled(visualizerObject, 0, 0);
    visualizerObject.clearScreen();
    return distanceTraveled;
  }

  public String getString(){
    return getExecutableName(executableType);
  }
}