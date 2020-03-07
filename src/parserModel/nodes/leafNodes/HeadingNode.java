package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A Leaf Node that returns the heading of the currently active turtle
 *
 * @author Mariusz Derezinski-Choo
 */
public class HeadingNode extends LeafNode {

  /**
   * Construct a Heading Node object
   * @param text the user-inputted text associated with this call
   */
  public HeadingNode(String text) {
    super(text);
  }

  @Override
  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getHeading();
  }
}
