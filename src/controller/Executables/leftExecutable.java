package controller.Executables;
import Visualizer.Visualizer;

public class leftExecutable extends Executable {
  private double angle;
  public leftExecutable(double angleInput){
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject){
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = (currentAngle+angle)%360;
    visualizerObject.setTurtleAngle(newAngle);
    return angle;
  }


}
