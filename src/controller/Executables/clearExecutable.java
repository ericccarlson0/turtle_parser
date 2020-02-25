package controller.Executables;
import static controller.Executables.setxyExecutable.getDistanceTraveled;
import Visualizer.Visualizer;


public class clearExecutable extends Executable {
  public clearExecutable(){
  }

  public double run(Visualizer visualizerObject){
    visualizerObject.clear();
    double distanceTraveled = getDistanceTraveled(visualizerObject,0,0);
    visualizerObject.setTurtleX(0);
    visualizerObject.setTurtleY(0);
    return distanceTraveled;
  }


}
