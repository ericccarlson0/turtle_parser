package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

public class PenDownNode extends LeafNode {
  private static final double TRUE = 1.0;
  private static final double FALSE = 0.0;

  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getPenDown()? TRUE : FALSE;
  }
}
