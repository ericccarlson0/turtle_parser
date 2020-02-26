package execution;

import visualizer.Visualizer;


public class YCorExecutable extends Executable {
  private final String executableType = "YCoordinate";
  public YCorExecutable(){
  }

  public double run(Visualizer visualizerObject){

    visualizerObject.addUserInput(Double.toString(visualizerObject.getTurtleY()));//TODO uncomment next
    return visualizerObject.getTurtleY();

    /*
    visualizerObject.addUserInput(Double.toString(visualizerObject.getTurtleGameY()));
    return visualizerObject.getTurtleGameY();

     */
  }


  public String getString() {
    return getExecutableName(executableType);
  }


}
