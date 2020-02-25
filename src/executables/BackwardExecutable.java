package executables;
import Visualizer.Visualizer;
import java.util.ResourceBundle;


public class BackwardExecutable extends Executable {
  private double distance;
  private final String executableType = "Backward";
  public BackwardExecutable(double distanceUnit){
    distance = distanceUnit;
  }

  public double run(Visualizer visualizerObject){
    double currentXPosition = visualizerObject.getTurtleX();
    double currentYPosition = visualizerObject.getTurtleY();
    double currentAngle = visualizerObject.getTurtleAngle();
    double newXPosition = currentXPosition - Math.cos(currentAngle)*distance;
    double newYPosition = currentYPosition - Math.sin(currentAngle)*distance;
    visualizerObject.setTurtleX(newXPosition);
    visualizerObject.setTurtleY(newYPosition);
    return distance;
  }

  public String getString(){
    return executableName +
  }
}
