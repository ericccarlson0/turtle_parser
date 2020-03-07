package parserModel.nodes.parentNodes.binaryOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Math Node that computes the sum of its children
 *
 * @author Mariusz Derezinski-Choo
 */
public class SumNode extends BinaryOperationSingleExecutionNode {
    public double execute(TurtleContext context) {
        if(arguments.size() < 2){
            throw new InsufficientArgumentException();
        }
        Iterator<ParserNode> iterator = arguments.iterator();
        double ret = 0.0;
        do {
            ret += iterator.next().execute(context);
        } while(iterator.hasNext());
        return ret;
    }
}
