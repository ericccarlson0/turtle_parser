package parserModel.nodes.turtleQueries;

import parserModel.GlobalData;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

public class HeadingNode extends CommandParserNode {

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(TurtleContext context) {
    TurtleData td = GlobalData.getInstance().turtleData();
    return td.getHeading();
  }

  public boolean isComplete() {
    return true;
  }
}
