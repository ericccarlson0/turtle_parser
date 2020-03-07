package parserModel.nodes.turtleQueries;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

public class ShowingPNode extends CommandParserNode {

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(TurtleContext context) {
    return 0.0; //GlobalData.getInstance().g FIXME
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "SHOWINGP";
  }
}
