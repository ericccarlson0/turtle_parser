package parserModel.nodes.parentNodes.multiOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Binary Operation Node that returns 1 only if the
 * first operand evaluates to a value greater than the second
 * operand, and 0 otherwise
 *
 * @author Mariusz Derezinski-Choo
 */
public class GreaterNode extends MultiOperandNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    public GreaterNode(String text) {
        super(text);
    }

    protected void validateArguments(){
        if(arguments.size() < 2){
            throw new InsufficientArgumentException(toString());
        }
    }

    @Override
    public double runValidated(TurtleContext context) {

        Iterator<ParserNode> iterator = arguments.iterator();
        double previousValue = iterator.next().execute(context);
        boolean ret = true;
        while(iterator.hasNext()){
            double nextValue = iterator.next().execute(context);
            ret = ret && (previousValue > nextValue);
            previousValue = nextValue;
        }
        return ret ? RETURN_TRUE : RETURN_FALSE;
    }
}
