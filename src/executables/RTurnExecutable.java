package executables;
import Visualizer.Visualizer;


public class RTurnExecutable extends Executable {
  private double angle;
  public RTurnExecutable(double angleInput){
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject){
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = (currentAngle-angle)%360;
    visualizerObject.setTurtleAngle(newAngle);
    return angle;
  }

  @Override
  public String getString() {
    return null;
  }


}
