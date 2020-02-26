package executables;
import visualizer.Visualizer;


public class BackwardExecutable extends Executable {
  private double distance;
  private final String executableType = "Backward";
  public BackwardExecutable(double distanceUnit){
    distance = distanceUnit;
  }

  public double run(Visualizer visualizerObject){
    for(int i=0; i<distance; i++){
      double currentXPosition = visualizerObject.getTurtleX();
      double currentYPosition = visualizerObject.getTurtleY();
      double currentAngle = visualizerObject.getTurtleAngle();
      double newXPosition = currentXPosition - Math.cos(currentAngle)*1;
      double newYPosition = currentYPosition - Math.sin(currentAngle)*1;
      visualizerObject.setTurtleX(newXPosition);
      visualizerObject.setTurtleY(newYPosition);
      visualizerObject.draw();
    }
    return distance;
  }

  public String getString(){
    return getExecutableName(executableType)+" "+distance;

  }
}
