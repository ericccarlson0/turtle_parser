package parserModel.TurtleQueries;
import executables.Executable;
import executables.YCorExecutable;
import java.util.List;
import parserModel.ParserNode;

public class YCorNode extends ParserNode {
  private List<Executable> executableQueue;

  public YCorNode(List<Executable> queue){
    executableQueue = queue;
  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute() {
    executableQueue.add(new YCorExecutable());
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
