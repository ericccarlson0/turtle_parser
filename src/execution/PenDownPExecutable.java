<<<<<<< HEAD:src/execution/PenDownPExecutable.java
package execution;
import visualizer.Visualizer;
=======
package executables;
>>>>>>> master:src/executables/PenDownPExecutable.java


public class PenDownPExecutable extends Executable {
  private final String executableType = "IsPenDown";

  public PenDownPExecutable(){
  }

  public double run(Visualizer visualizerObject){
    return visualizerObject.getTurtlePen();
  }

  public String getString() {
    return getExecutableName(executableType);
  }

}
