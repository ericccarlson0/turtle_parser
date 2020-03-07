package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;
import parserModel.nodes.leafNodes.LeafNode;

public class IsPenDownNode extends LeafNode {
  private static final double TRUE = 1.0;
  private static final double FALSE = 0.0;

  public IsPenDownNode(String text) {
    super(text);
  }

  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getPenDown()? TRUE : FALSE;
  }
}
