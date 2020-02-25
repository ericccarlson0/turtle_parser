import parserModel.ParserNode;
import parserModel.TreeParser;

public class Controller {
  public TreeParser myTreeParser;

  public Controller () {
    myTreeParser = new TreeParser();
  }

  public void step (String input) {


    ParserNode root = myTreeParser.parseString(input);
    root.execute(); // ***
  }
  // getTurtleX/Y, setTurtleX/Y, getIndex, setTurtleAngle, ...
}