package parserModel.TurtleQueries;
import executables.Executable;
import executables.HeadingExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class HeadingNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public HeadingNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
    context.getExecutableQueue().add(new HeadingExecutable());
    return 0; // FIXME
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "Heading";
  }
}
