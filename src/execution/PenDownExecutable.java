<<<<<<< HEAD:src/execution/PenDownExecutable.java
package execution;
import visualizer.Visualizer;
=======
package executables;
>>>>>>> master:src/executables/PenDownExecutable.java


public class PenDownExecutable extends Executable {
  private final String executableType = "PenDown";
  public PenDownExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(true);
    return 1;
  }

  public String getString(){
    return getExecutableName(executableType);
  }


}
