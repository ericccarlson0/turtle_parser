package parserModel.nodes.turtleQueries;

import parserModel.GlobalData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

public class YCorNode extends CommandParserNode {

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(TurtleContext context) {
    return GlobalData.getInstance().turtleData().getY();
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "XCor";
  }
}
