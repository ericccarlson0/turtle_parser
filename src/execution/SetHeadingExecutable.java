package execution;

import visualizer.Visualizer;


public class SetHeadingExecutable extends Executable {
  private final String executableType = "SetHeading";
  private double angle;

  public SetHeadingExecutable(double angleInput) {
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject) {
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = angle%360;
    double radiansMoved = newAngle-currentAngle;
    visualizerObject.setTurtleAngle(-newAngle); //TODO why negative again
    return Math.toDegrees(radiansMoved);
  }


  public String getString(){
    return getExecutableName(executableType)+" "+angle;
  }
}


