package executables;
import visualizer.Visualizer;


public class SetHeadingExecutable extends Executable {

  private double angle;

  public SetHeadingExecutable(double angleInput) {
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject) {
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = angle%360;
    double degreesMoved = newAngle-currentAngle;
    visualizerObject.setTurtleAngle(newAngle);
    return degreesMoved;
  }
}


