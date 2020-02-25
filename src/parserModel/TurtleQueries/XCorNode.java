package parserModel.TurtleQueries;
import executables.Executable;
import executables.XCorExecutable;
import java.util.List;
import parserModel.ParserNode;

public class XCorNode extends ParserNode {
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
