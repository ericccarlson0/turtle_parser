<<<<<<< HEAD:src/executables/showTurtleExecutable.java
package executables;
=======
package controller.Executables;
import Visualizer.Visualizer;
>>>>>>> cy111:src/controller/Executables/showTurtleExecutable.java

public class showTurtleExecutable extends Executable {
  public showTurtleExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.show();
    return 1;
  }


}
