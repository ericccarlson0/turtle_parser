package executables;
import visualizer.Visualizer;

public class ForwardExecutable extends Executable {
  private double distance;
  public ForwardExecutable(double distanceUnit){
    distance = distanceUnit;
  }

  public double run(Visualizer visualizerObject){
    double currentXPosition = visualizerObject.getTurtleX();
    double currentYPosition = visualizerObject.getTurtleY();
    double currentAngle = visualizerObject.getTurtleAngle();
    double newXPosition = currentXPosition + Math.cos(currentAngle)*distance;
    double newYPosition = currentYPosition + Math.sin(currentAngle)*distance;
    visualizerObject.setTurtleX(newXPosition);
    visualizerObject.setTurtleY(newYPosition);
    return distance;
  }


}
