package executables;
import visualizer.Visualizer;


public class HeadingExecutable extends Executable {
  private final String executableType = "Heading";
  private double myHeading;

  public HeadingExecutable(double degrees) {
    myHeading = degrees;
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtleAngle();
  }

  public String getString(){
    return getExecutableName(executableType);
  }

}
