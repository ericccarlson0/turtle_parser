package parserModel.nodes.parentNodes.binaryOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Binary Operation Node that checks for
 * equality between two nodes, returnin 1 only
 * if both nodes evaluate to the same quantiy, and
 * 0 otherwise
 *
 * @author Mariusz Derezinski-Choo
 */
public class EqualNode extends BinaryOperationSingleExecutionNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    @Override
    public double execute(TurtleContext context) {
        if(arguments.size() < 2){
            throw new InsufficientArgumentException();
        }
        Iterator<ParserNode> iterator = arguments.iterator();

        double firstValue = iterator.next().execute(context);
        boolean ret = true;
        while(iterator.hasNext()){
            ret = ret && (firstValue == iterator.next().execute(context));
        }
        return ret ? RETURN_TRUE : RETURN_FALSE;
    }
}
