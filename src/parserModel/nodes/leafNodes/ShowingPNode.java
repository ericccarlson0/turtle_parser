package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A Leaf Node that Queries whether a Turtle is showing or not
 *
 * @author Mariusz Derezinski-Choo
 */
public class ShowingPNode extends LeafNode {

  /**
   * Construct a ShowingPNode
   * @param text the user-inputted text associated with the construction of this Node
   */
  public ShowingPNode(String text) {
    super(text);
  }

  @Override
  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().isShowing() ? 1.0 : 0.0;
  }

}
