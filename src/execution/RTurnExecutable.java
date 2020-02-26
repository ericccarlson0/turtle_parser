package execution;

import visualizer.Visualizer;

public class RTurnExecutable extends ExecutableSuperClass {
  private final String executableType = "Right";
  private double angle;
  public RTurnExecutable(double angleInput){
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject){
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = (currentAngle+angle)%360;
    visualizerObject.setTurtleAngle(newAngle);
    return angle;
  }


  public String getString(){
    return getExecutableName(executableType)+" "+angle;
  }


}
