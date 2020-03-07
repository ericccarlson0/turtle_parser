package parserModel.nodes.parentNodes.binaryOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Math Node that computes the modulus of its children
 *
 * @author Mariusz Derezinski-Choo
 */
public class RemainderNode extends BinaryOperationSingleExecutionNode {
    public double execute(TurtleContext context) {
        if(arguments.size() < myMinArguments){
            throw new InsufficientArgumentException();
        }
        Iterator<ParserNode> iterator = arguments.iterator();
        double returning = iterator.next().execute(context);
        while(iterator.hasNext()){
            returning %= iterator.next().execute(context);
        }
        return returning;
    }
}
