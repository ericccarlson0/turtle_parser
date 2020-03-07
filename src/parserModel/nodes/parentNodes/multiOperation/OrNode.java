package parserModel.nodes.parentNodes.multiOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Binary Operation Node that returns 1 if
 * either of the operands evaluate to a
 * nonzero value
 *
 * @author Mariusz Derezinski-Choo
 */
public class OrNode extends MultiOperandNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;
    private static final double FALSE = 0.0;

    public OrNode(String text) {
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
        System.out.println("iterator contents are: ");
        boolean ret = true;
        while(iterator.hasNext()){
            double nextValue = iterator.next().execute(context);
            ret = ret || nextValue != FALSE;
        }
        return ret ? RETURN_TRUE : RETURN_FALSE;
    }
}
