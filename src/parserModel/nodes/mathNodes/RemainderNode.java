package parserModel.nodes.mathNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

/**
 * A Math Node that computes the modulus of its children
 *
 * @author Mariusz Derezinski-Choo
 */
public class RemainderNode extends BinaryOperationNode {
    public double execute(VisualContext context) {
        return operand1.execute(context) % operand2.execute(context);
    }
}
