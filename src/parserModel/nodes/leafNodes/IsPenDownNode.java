package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A Leaf Node that is executed to evaluate whether a turtle's pen is down or not
 *
 * @author Mariusz Mariusz Derezinski-Choo
 */
public class IsPenDownNode extends LeafNode {
  private static final double TRUE = 1.0;
  private static final double FALSE = 0.0;

  /**
   * Construct a IsPenDownNode object
   * @param text the user-inputted text associated with this call to IsPenDown
   */
  public IsPenDownNode(String text) {
    super(text);
  }

  @Override
  public double execute(TurtleContext context) {
    return context.getWorkingTurtle().getPenDown()? TRUE : FALSE;
  }
}
