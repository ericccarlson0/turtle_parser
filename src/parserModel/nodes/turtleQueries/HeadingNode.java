package parserModel.nodes.turtleQueries;

import execution.HeadingExecutable;
import parserModel.GlobalData;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

public class HeadingNode extends CommandParserNode {

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
    TurtleData td = GlobalData.getInstance().turtleData();
    context.getExecutableQueue().add(new HeadingExecutable());
    return td.getY(); // FIXME
  }

  public boolean isComplete() {
    return true;
  }
}
