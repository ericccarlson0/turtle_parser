package parserModel.TurtleQueries;
import execution.Executable;
import execution.XCorExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class XCorNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public XCorNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute() {
    executableQueue.add(new XCorExecutable());
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
