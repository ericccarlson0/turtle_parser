package execution;

import visualizer.Visualizer;


public class SetXYExecutable extends Executable {
  private final String executableType = "SetPosition";
  private double xSet;
  private double ySet;
  public SetXYExecutable(double xInput, double yInput){
    xSet=xInput;
    ySet=yInput;
  }

  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject, xSet, ySet);
    visualizerObject.setTurtleX(xSet);
    visualizerObject.setTurtleY(ySet);
    return distanceTraveled;
  }


  public static double getDistanceTraveled(Visualizer visualizerObject, double xSet, double ySet) {
    double currentXPosition = visualizerObject.getTurtleX();
    double currentYPosition = visualizerObject.getTurtleY();
    double xDistance = xSet - currentXPosition;
    double yDistance = ySet - currentYPosition;
    return Math.sqrt(Math.pow(xDistance,2)+Math.pow(yDistance,2));
  }

  public String getString(){
    return getExecutableName(executableType)+" "+xSet+" "+ySet;
  }


}
