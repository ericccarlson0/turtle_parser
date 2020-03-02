package parserModel.nodes.mathNodes;

import parserModel.nodes.BinaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the sum of its children
 *
 * @author Mariusz Derezinski-Choo
 */
public class SumNode extends BinaryOperationNode {
    public double execute(TurtleContext context) {
        return operand1.execute(context) + operand2.execute(context);
    }
}
