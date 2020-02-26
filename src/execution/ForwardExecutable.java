package execution;

import visualizer.Visualizer;

public class ForwardExecutable extends Executable {
  private final String executableType = "Forward";
  private double distance;
  public ForwardExecutable(double distanceUnit){
    distance = distanceUnit;
  }

  public double run(Visualizer visualizerObject){
    for(int i=0; i<distance; i++){
      double currentXPosition = visualizerObject.getTurtleX();
      double currentYPosition = visualizerObject.getTurtleY();
      double currentAngle = visualizerObject.getTurtleAngle();
      double newXPosition = currentXPosition + Math.cos(Math.toRadians(currentAngle))*1;
      double newYPosition = currentYPosition + Math.sin(Math.toRadians(currentAngle))*1;
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
