package parserModel.nodes.control;

import parserModel.nodes.BinaryOperationNode;
import parserModel.TurtleContext;

/**
 * A CommandParserNode that implements the behavior of an
 * if tree. the if node is executed
 * if the conditional evaluates to true (nonzero)
 * otherwise nothing occurs and 0 is returned
 *
 * @author Mariusz Derezinski-Choo
 */
public class IfNode extends BinaryOperationNode {
    private static final double FALSE = 0.0;
    private static final double RETURN_FALSE = 0.0;

    @Override
    public double execute(TurtleContext context) {
        if(operand1.execute(context) != FALSE){
            return operand2.execute(context);
        }
        return RETURN_FALSE;
    }
}
