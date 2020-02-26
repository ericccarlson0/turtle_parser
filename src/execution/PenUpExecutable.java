<<<<<<< HEAD:src/execution/PenUpExecutable.java
package execution;
import visualizer.Visualizer;
=======
package executables;
>>>>>>> master:src/executables/PenUpExecutable.java


public class PenUpExecutable extends Executable {
  private final String executableType = "PenUp";
  public PenUpExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(false);
    return 0;
  }

  public String getString(){
    return getExecutableName(executableType);

  }


}
