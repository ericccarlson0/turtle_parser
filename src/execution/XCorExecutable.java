package execution;

import visualizer.Visualizer;

public class XCorExecutable extends Executable {
  private final String executableType = "XCoordinate";
  public XCorExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.addUserInput(Double.toString(visualizerObject.getTurtleX()));
    return visualizerObject.getTurtleX();
  }


  public String getString() {
    return getExecutableName(executableType);
  }


}
