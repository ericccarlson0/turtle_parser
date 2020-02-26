package parserModel.turtleQueries;
import execution.Executable;
import execution.XCorExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class XCorNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public XCorNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
    context.getExecutableQueue().add(new XCorExecutable());
    return 0; // FIXME
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "XCor";
  }
}
