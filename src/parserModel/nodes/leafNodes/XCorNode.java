package parserModel.nodes.leafNodes;


import parserModel.TurtleContext;

public class XCorNode extends LeafNode {

  public XCorNode(String text) {
    super(text);
  }

  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getX();
  }
}
