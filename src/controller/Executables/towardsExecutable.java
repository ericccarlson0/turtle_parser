package controller.Executables;
import Visualizer.Visualizer;

public class towardsExecutable extends Executable {
  private double xHeading;
  private double yHeading;
  public towardsExecutable(double xInput, double yInput){
    xHeading=xInput;
    yHeading=yInput;
  }

  public double run(Visualizer visualizerObject){
    double currentXPosition = visualizerObject.getTurtleX();
    double currentYPosition = visualizerObject.getTurtleY();
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = Math.atan((yHeading-currentYPosition)/(xHeading-currentXPosition));
    if(xHeading-currentXPosition<0){
      newAngle+=180;
    }
    visualizerObject.setTurtleAngle(newAngle);
    return (newAngle-currentAngle)%360;
  }


}
