import ParserModel.ParserNode;
import ParserModel.TreeParser;

public class Controller {
  public TreeParser myTreeParser;

  public Controller () {
    myTreeParser = new TreeParser();
  }

  public void step (String input) {
    ParserNode root = myTreeParser.parseString(input);
  }
  // getTurtleX/Y, setTurtleX/Y, getIndex, setTurtleAngle, ...
}