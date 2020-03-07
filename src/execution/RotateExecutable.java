package execution;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for RightTurn command.
 */
public class RotateExecutable implements Executable{
  private String name;

  private List<Integer> myIDs;
  private List<Double> myStartAngles;
  private List<Double> myEndAngles;

  public RotateExecutable(){
    myIDs = new ArrayList<>();
    myStartAngles = new ArrayList<>();
    myEndAngles = new ArrayList<>();
  }

  public void addMove(int id, double startAngle, double endAngle){
    myIDs.add(id);
    myStartAngles.add(startAngle);
    myEndAngles.add(endAngle);
  }

  @Override
  public void execute(Visualizer visualizer) {
    visualizer.setTurtleAngle(new ArrayList<>(myIDs), new ArrayList<>(myStartAngles), new ArrayList<>(myEndAngles));
  }

  @Override
  public String getCommandName(String language) {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
