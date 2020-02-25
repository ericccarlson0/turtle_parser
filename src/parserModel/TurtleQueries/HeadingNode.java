package parserModel.TurtleQueries;
import execution.Executable;
import execution.HeadingExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class HeadingNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public HeadingNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute() {
    executableQueue.add(new HeadingExecutable());
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
