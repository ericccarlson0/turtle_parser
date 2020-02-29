package parserModel.nodes.turtleQueries;

import parserModel.GlobalData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

public class ShowingPNode extends CommandParserNode {

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
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
