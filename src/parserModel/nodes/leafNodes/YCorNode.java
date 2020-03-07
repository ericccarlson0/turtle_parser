package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

public class YCorNode extends LeafNode {
  public YCorNode(String text) {
    super(text);
  }

  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getY();
  }
}
