package parserModel.nodes.turtleQueries;

import parserModel.GlobalData;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

import java.util.List;

public class HeadingNode extends CommandParserNode {

  public void addNode(ParserNode node) {
    throw new UnsupportedOperationException();
  }

  public double execute(TurtleContext context) {
    // get the heading of the LAST turtle
    List<Double> turtles = context.getActiveTurtles();
    TurtleData td = context.getData().turtleData(turtles.get(turtles.size()-1));
    return td.getHeading();
  }

  public boolean isComplete() {
    return true;
  }
}
