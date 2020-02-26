package parserModel.turtleQueries;
import execution.Executable;
import execution.YCorExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class YCorNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public YCorNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
    context.getExecutableQueue().add(new YCorExecutable());
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
