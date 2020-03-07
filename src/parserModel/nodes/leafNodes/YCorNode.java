package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A LeafNode that queries the Y coordinate of the currently active turtle
 *
 * @author Mariusz Derezinski-Choo
 */
public class YCorNode extends LeafNode {
  /**
   * Construct a YCorNode
   * @param text the user-inputted text associated with the construction of this Node
   */
  public YCorNode(String text) {
    super(text);
  }

  @Override
  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getY();
  }
}
