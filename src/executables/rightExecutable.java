<<<<<<< HEAD:src/executables/rightExecutable.java
package executables;
=======
package controller.Executables;
import Visualizer.Visualizer;
>>>>>>> cy111:src/controller/Executables/rightExecutable.java

public class rightExecutable extends Executable {
  private double angle;
  public rightExecutable(double angleInput){
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject){
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = (currentAngle-angle)%360;
    visualizerObject.setTurtleAngle(newAngle);
    return angle;
  }


}
