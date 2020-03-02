package parserModel.nodes.turtleQueries;

import parserModel.GlobalData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

public class PenDownPNode extends CommandParserNode {

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(TurtleContext context) {
    return GlobalData.getInstance().turtleData().getPenDown()? 1 : 0;
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "PENDOWNP";
  }
}
