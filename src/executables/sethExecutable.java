<<<<<<< HEAD:src/executables/sethExecutable.java
package executables;
=======
package controller.Executables;
import Visualizer.Visualizer;
>>>>>>> cy111:src/controller/Executables/sethExecutable.java

public class sethExecutable extends Executable {

  private double angle;

  public sethExecutable(double angleInput) {
    angle = angleInput;
  }

  public double run(Visualizer visualizerObject) {
    double currentAngle = visualizerObject.getTurtleAngle();
    double newAngle = angle%360;
    double degreesMoved = newAngle-currentAngle;
    visualizerObject.setTurtleAngle(newAngle);
    return degreesMoved;
  }
}


