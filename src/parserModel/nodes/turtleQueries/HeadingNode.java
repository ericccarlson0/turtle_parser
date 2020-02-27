package parserModel.nodes.turtleQueries;

import execution.HeadingExecutable;
import execution.PenDownPExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleData;
import visualizer.VisualContext;

public class HeadingNode extends CommandParserNode {

  public HeadingNode(){

  }

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

  @Override
  public String toString(){
    return "Heading";
  }
}
