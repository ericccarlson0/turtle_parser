package parserModel.TurtleQueries;
import executables.Executable;
import executables.PenDownPExecutable;
import executables.PenDownPExecutable;
import java.util.List;
import parserModel.ParserNode;

public class PenDownPNode extends ParserNode {
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
