package executables;
import Visualizer.Visualizer;


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

  public String getString(){
    return getExecutableName(executableType);
  }
}


