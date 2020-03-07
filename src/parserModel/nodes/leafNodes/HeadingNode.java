package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

public class HeadingNode extends LeafNode {
  public HeadingNode(String text) {
    super(text);
  }

  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getHeading();
  }
}
