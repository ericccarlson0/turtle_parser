package parserModel.TurtleQueries;
import executables.Executable;
import executables.HeadingExecutable;
import java.util.List;

import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;
import visualizer.VisualContext;

public class HeadingNode extends CommandParserNode {

  public HeadingNode(){

  }

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(VisualContext context) {
    TurtleData td = GlobalData.getInstance().turtleData();
    return td.getY(); // FIXME
  }

  public boolean isComplete() {
    return true;
  }

  @Override
  public String toString(){
    return "Heading";
  }
}
