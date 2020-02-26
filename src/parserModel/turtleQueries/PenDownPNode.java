package parserModel.turtleQueries;
import execution.Executable;
import execution.PenDownPExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class PenDownPNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public PenDownPNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute() {
    executableQueue.add(new PenDownPExecutable());
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
