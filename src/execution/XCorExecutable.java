package execution;

import visualizer.Visualizer;

public class XCorExecutable extends ExecutableSuperClass {
  private final String executableType = "XCoordinate";
  public XCorExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.addUserInput(Double.toString(visualizerObject.getTurtleX()));//TODO uncomment the next
    return visualizerObject.getTurtleX();
    /*
    visualizerObject.addUserInput(Double.toString(visualizerObject.getTurtleGameX()));//
    return visualizerObject.getTurtleGameX();
     */

  }


  public String getString() {
    return getExecutableName(executableType);
  }


}
