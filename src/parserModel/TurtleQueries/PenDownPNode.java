package parserModel.TurtleQueries;
import executables.Executable;
import executables.PenDownPExecutable;
import executables.PenDownPExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class PenDownPNode extends CommandParserNode {

  public PenDownPNode() {
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
    context.getExecutableQueue().add(new PenDownPExecutable());
    return 0; // FIXME
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "PENDOWNP";
  }
}
