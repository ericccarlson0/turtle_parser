package parserModel.TurtleQueries;
import execution.Executable;
import execution.ShowingPExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class ShowingPNode extends CommandParserNode {
  private List<Executable> executableQueue;

  public ShowingPNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute() {
    executableQueue.add(new ShowingPExecutable());
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
