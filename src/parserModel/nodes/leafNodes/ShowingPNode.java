package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

public class ShowingPNode extends LeafNode {

  public ShowingPNode(String text) {
    super(text);
  }

  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().isShowing() ? 1.0 : 0.0;
  }

}
