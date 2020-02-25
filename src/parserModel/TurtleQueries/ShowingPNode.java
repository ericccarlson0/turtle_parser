package parserModel.TurtleQueries;
import executables.Executable;
import executables.ShowingPExecutable;
import java.util.List;
import parserModel.ParserNode;

public class ShowingPNode extends ParserNode {
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
