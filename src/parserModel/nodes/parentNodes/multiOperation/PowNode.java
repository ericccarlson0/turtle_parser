package parserModel.nodes.parentNodes.multiOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;
import java.util.Iterator;

/**
 * A Math Node that computes the first operand raised to the power of the second operand
 *
 * @author Mariusz Derezinski-Choo
 */
public class PowNode extends MultiOperandNode {
    public PowNode(String text) {
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
        double ret = iterator.next().execute(context);
        do {
            ret = Math.pow(ret, iterator.next().execute(context));
        } while(iterator.hasNext());
        return ret;
    }
}
