package execution;

import visualizer.Visualizer;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Cemal Yagcioglu Mariusz Derezinski-Choo
 * This subclass creates the executable command
 * object for Backward command.
 */
public class MoveExecutable implements Executable {
  private static final String EXECUTABLE_TYPE = "Move";

  private List<Integer> myIDs;
  private List<Double> myStartXs;
  private List<Double> myStartYs;
  private List<Double> myEndXs;
  private List<Double> myEndYs;
  private List<Boolean> myDraws;
  private String myName;

  public MoveExecutable(String name){
    this();
    myName = name;
  }

  public MoveExecutable(){
    myIDs = new ArrayList<>();
    myStartXs = new ArrayList<>();
    myStartYs = new ArrayList<>();
    myEndXs = new ArrayList<>();
    myEndYs = new ArrayList<>();
    myDraws = new ArrayList<>();
  }

  public void addMove(int id, double startX, double startY, double endX, double endY, boolean draw){
    myIDs.add(id);
    myStartXs.add(startX);
    myStartYs.add(startY);
    myEndXs.add(endX);
    myEndYs.add(endY);
    myDraws.add(draw);
  }

  @Override
  public void execute(Visualizer visualizer) {
    visualizer.setPosition(new ArrayList<>(myIDs), new ArrayList<>(myStartXs), new ArrayList<>(myStartYs), new ArrayList<>(myEndXs), new ArrayList<>(myEndYs), new ArrayList<>(myDraws));
  }
  /**
   * Returns the string value to be shown in the executable history.
   * @return Executable Name.
   */
  public String getString() {
    //return getExecutableName(EXECUTABLE_TYPE);
    return "";
  }

  @Override
  public String getName() {
    return myName;
  }

  @Override
  public void setName(String name) {
    this.myName = name;
  }

}
