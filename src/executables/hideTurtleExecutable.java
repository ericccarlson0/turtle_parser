<<<<<<< HEAD:src/executables/hideTurtleExecutable.java
package executables;
=======
package controller.Executables;
import Visualizer.Visualizer;
>>>>>>> cy111:src/controller/Executables/hideTurtleExecutable.java

public class hideTurtleExecutable extends Executable {
  public hideTurtleExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.hide();
    return 0;
  }


}
