package parserModel.nodes.parentNodes.binaryOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Binary Operation Node that Ands the two nodes,
 * returning 1 only if both nodes evaluate to a nonzero
 * value
 *
 * @author Mariusz Derezinski-Choo
 */
public class AndNode extends BinaryOperationSingleExecutionNode {
    private static final double FALSE = 0;
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    @Override
    public double execute(TurtleContext context) {
        if(arguments.size() < 2){
            throw new InsufficientArgumentException();
        }
        Iterator<ParserNode> iterator = arguments.iterator();
        boolean ret = true;
        while(iterator.hasNext()){
            ret = ret && (iterator.next().execute(context) != FALSE);
        }
        return ret ? RETURN_TRUE : RETURN_FALSE;
    }
}