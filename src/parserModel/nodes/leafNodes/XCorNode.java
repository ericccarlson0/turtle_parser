package parserModel.nodes.leafNodes;


import parserModel.TurtleContext;

/**
 * A LeafNode that fetches the current X coordinate of the current working Turtle
 */
public class XCorNode extends LeafNode {

  /**
   * Construct an XCorNode
   * @param text the user-inputted text associated with the construction of this Node
   */
  public XCorNode(String text) {
    super(text);
  }

  @Override
  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getX();
  }
}
