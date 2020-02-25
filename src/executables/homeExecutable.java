<<<<<<< HEAD:src/executables/homeExecutable.java
package executables;
=======
package controller.Executables;
import static controller.Executables.setxyExecutable.getDistanceTraveled;
import Visualizer.Visualizer;
>>>>>>> cy111:src/controller/Executables/homeExecutable.java

public class homeExecutable extends Executable {

  public homeExecutable(){ }

  public double run(Visualizer visualizerObject){
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleX(0);
    visualizerObject.setTurtleY(0);
    return distanceTraveled;
  }


}
