<<<<<<< HEAD:src/executables/pendownExecutable.java
package executables;
=======
package controller.Executables;
import Visualizer.Visualizer;
>>>>>>> cy111:src/controller/Executables/pendownExecutable.java

public class pendownExecutable extends Executable {
  public pendownExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(true);
    return 1;
  }


}
