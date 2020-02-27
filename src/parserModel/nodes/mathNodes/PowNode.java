package parserModel.nodes.mathNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

/**
 * A Math Node that computes the first operand raised to the power of the second operand
 *
 * @author Mariusz Derezinski-Choo
 */
public class PowNode extends BinaryOperationNode {
    public double execute(VisualContext context) { return Math.pow(operand1.execute(context), operand2.execute(context)); }
}
