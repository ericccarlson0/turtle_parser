package parserModel.nodes.parentNodes.multiOperation;

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
public class AndNode extends MultiOperandNode {
    private static final double FALSE = 0;
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    public AndNode(String text) {
        super(text);
    }

    protected void validateArguments(){
        if(arguments.size() < 2){
            throw new InsufficientArgumentException();
        }
    }

    @Override
    public double runValidated(TurtleContext context) {
        Iterator<ParserNode> iterator = arguments.iterator();
        boolean ret = true;
        while(iterator.hasNext()){
            double nextValue = iterator.next().execute(context);
            ret = ret && nextValue != FALSE;
        }
        return ret ? RETURN_TRUE : RETURN_FALSE;
    }
}