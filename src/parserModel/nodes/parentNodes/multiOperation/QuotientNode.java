package parserModel.nodes.parentNodes.multiOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Math Node that computes the quotient of its children
 * special care is taken to ensure division by zero is handled
 *
 * @author Mariusz Derezinski-Choo
 */
public class QuotientNode extends MultiOperandNode {
    public QuotientNode(String text) {
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
        double ret = iterator.next().execute(context);
        do {
            ret /= iterator.next().execute(context);
        } while(iterator.hasNext());
        return ret;
    }
}
