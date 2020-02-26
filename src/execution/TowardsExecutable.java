package execution;

import visualizer.Visualizer;


public class TowardsExecutable extends ExecutableSuperClass {
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
    double newAngle;
    if(xHeading-currentXPosition==0 && yHeading-currentYPosition==0){
      newAngle = currentAngle;
    }
    else {
      newAngle = -Math
          .toDegrees(Math.atan((yHeading - currentYPosition) / (xHeading - currentXPosition)));
    }
    if(xHeading-currentXPosition<0){
      newAngle+=180;
    }
    visualizerObject.setTurtleAngle(newAngle);
    return (newAngle-currentAngle)%360;
  }


  public String getString() {
    return getExecutableName(executableType) + " " + xHeading + " " + yHeading;
  }


}
