<<<<<<< HEAD:src/executables/penupExecutable.java
package executables;
=======
package controller.Executables;
import Visualizer.Visualizer;
>>>>>>> cy111:src/controller/Executables/penupExecutable.java

public class penupExecutable extends Executable {
  public penupExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.setTurtlePen(false);
    return 0;
  }


}
