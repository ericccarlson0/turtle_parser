package parserModel.nodes.turtleQueries;
import execution.Executable;
import execution.ShowingPExecutable;
import java.util.List;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

public class ShowingPNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public ShowingPNode() {
  }
  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
    context.getExecutableQueue().add(new ShowingPExecutable());
    return 0; // FIXME
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "SHOWINGP";
  }
}
