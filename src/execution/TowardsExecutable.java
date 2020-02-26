package execution;

import visualizer.Visualizer;


public class TowardsExecutable extends Executable {
  private final String executableType = "SetTowards";
  private double xHeading;
  private double yHeading;
  public TowardsExecutable(double xInput, double yInput){
    xHeading=xInput;
    yHeading=yInput;
  }

  public double run(Visualizer visualizerObject){
    double currentXPosition = visualizerObject.getTurtleX()-350; //TODO change it to getTurtleGameX
    double currentYPosition = 350-(visualizerObject.getTurtleY()); //TODO change it to getTurtleGameY
    System.out.println(currentXPosition);
    System.out.println(currentYPosition);
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = Math.toDegrees(Math.atan((yHeading-currentYPosition)/(xHeading-currentXPosition)));
    System.out.println(newAngle);
    if(xHeading-currentXPosition<0){
      newAngle+=180;
    }
    System.out.println(newAngle);
    visualizerObject.setTurtleAngle(-newAngle);  //TODO why does this need to be negative
    return (newAngle-currentAngle)%360;
  }


  public String getString() {
    return getExecutableName(executableType) + " " + xHeading + " " + yHeading;
  }


}
