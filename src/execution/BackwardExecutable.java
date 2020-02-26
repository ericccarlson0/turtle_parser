package execution;

public class BackwardExecutable extends Executable {
  private double distance;
  private final String executableType = "Backward";

  public BackwardExecutable(double distanceUnit){
    distance = distanceUnit;
  }

  public double run(visualizer.Visualizer visualizerObject){
    double angle = visualizerObject.getTurtleAngle();
    double newX = visualizerObject.getTurtleX() - Math.cos(Math.toRadians(angle))*distance;
    double newY = visualizerObject.getTurtleY() - Math.sin(Math.toRadians(angle))*distance;
    visualizerObject.setTurtleX(newX);
    visualizerObject.setTurtleY(newY);
    visualizerObject.draw();

    return distance;
  }

  public String getString(){
    return getExecutableName(executableType)+" "+distance;

  }
}
