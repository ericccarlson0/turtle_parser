package executables;
import visualizer.Visualizer;

public class LTurnExecutable extends Executable {
  private final String executableType = "Left";
  private double angle;
  public LTurnExecutable(double angleInput){
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject){
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = (currentAngle+angle)%360;
    visualizerObject.setTurtleAngle(newAngle);
    return angle;
  }

  public String getString(){
    return getExecutableName(executableType)+" "+angle;
  }
  
}
