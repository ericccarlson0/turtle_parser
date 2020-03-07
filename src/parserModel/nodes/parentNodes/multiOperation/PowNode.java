package parserModel.nodes.parentNodes.binaryOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;
import java.util.Iterator;

/**
 * A Math Node that computes the first operand raised to the power of the second operand
 *
 * @author Mariusz Derezinski-Choo
 */
public class PowNode extends BinaryOperationSingleExecutionNode {
    public double execute(TurtleContext context) {
        if(arguments.size() < 2){
            throw new InsufficientArgumentException();
        }
        Iterator<ParserNode> iterator = arguments.iterator();
        double ret = iterator.next().execute(context);
        do {
            ret = Math.pow(ret, iterator.next().execute(context));
        } while(iterator.hasNext());
        return ret;
    }
}
