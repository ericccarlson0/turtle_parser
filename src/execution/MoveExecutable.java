package execution;

import javafx.beans.property.StringProperty;
import parserModel.TurtleContext;
import visualizer.Visualizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Cemal Yagcioglu
 * This subclass creates the executable command
 * object for Backward command.
 */
public class MoveExecutable implements Executable {

  private List<Integer> myIDs;
  private List<Double> myStartXs;
  private List<Double> myStartYs;
  private List<Double> myEndXs;
  private List<Double> myEndYs;

  public MoveExecutable(){
    myIDs = new ArrayList<>();
    myStartXs = new ArrayList<>();
    myStartYs = new ArrayList<>();
    myEndXs = new ArrayList<>();
    myEndYs = new ArrayList<>();
  }

  public void addMove(int id, double startX, double startY, double endX, double endY){
    myIDs.add(id);
    myStartXs.add(startX);
    myStartYs.add(startY);
    myEndXs.add(endX);
    myEndYs.add(endY);
  }


  @Override
  public void execute(Visualizer visualizer) {
    visualizer.setPosition(new ArrayList<>(myIDs), new ArrayList<>(myStartXs), new ArrayList<>(myStartYs), new ArrayList<>(myEndXs), new ArrayList<>(myEndYs));
  }

  @Override
  public String getCommandName(String language) {
    return null;
  }

}
