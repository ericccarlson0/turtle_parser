package parserModel.nodes.parentNodes.multiOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Binary Operation Node that returns 1 only if the
 * first operand evaluates to a value not equal to
 * the second node, and 0 otherwise
 *
 * @author Mariusz Derezinski-Choo
 */
public class NotEqualNode extends MultiOperandNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    public NotEqualNode(String text) {
        super(text);
    }

    protected void validateArguments(){
        if(arguments.size() < 2){
            throw new InsufficientArgumentException();
        }
    }

    @Override
    public double runValidated(TurtleContext context) {
        System.out.println("executing a not equal node");
        Iterator<ParserNode> iterator = arguments.iterator();
        double previousValue = iterator.next().execute(context);
        boolean ret = true;
        while(iterator.hasNext()){
            double nextValue = iterator.next().execute(context);
            ret = ret && (previousValue != nextValue);
            previousValue = nextValue;
        }
        System.out.println("" + ret);
        return ret ? RETURN_TRUE : RETURN_FALSE;
    }
}
