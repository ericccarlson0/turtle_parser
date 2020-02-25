package executables;
import Visualizer.Visualizer;

public class LTurnExecutable extends Executable {
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


}
