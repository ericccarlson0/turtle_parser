package execution;

import visualizer.Visualizer;


public class SetXYExecutable extends ExecutableSuperClass {
  private final String executableType = "SetPosition";
  private double xSet;
  private double ySet;
  public SetXYExecutable(double xInput, double yInput){
    xSet=xInput;
    ySet=yInput;
  }

  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject, xSet, ySet);
    //visualizerObject.setTurtleX(xSet);
    //visualizerObject.setTurtleY(ySet);
    visualizerObject.setTurtleGameX(xSet);
    visualizerObject.setTurtleGameY(ySet);
    visualizerObject.draw();

    return distanceTraveled;
  }


  public static double getDistanceTraveled(Visualizer visualizerObject, double xSet, double ySet) {
    double currentXPosition = visualizerObject.getTurtleGameX();
    double currentYPosition = visualizerObject.getTurtleGameY();
    double xDistance = xSet - currentXPosition;
    double yDistance = ySet - currentYPosition;
    return Math.sqrt(Math.pow(xDistance,2)+Math.pow(yDistance,2));
  }

  public String getString(){
    return getExecutableName(executableType)+" "+xSet+" "+ySet;
  }


}
