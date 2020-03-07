package parserModel.nodes.parentNodes.multiOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Math Node that computes the product of its children
 *
 * @author Mariusz Derezinski-Choo
 */
public class ProductNode extends MultiOperandNode {
    public ProductNode(String text) {
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
        double ret = 1.0;
        do {
            ret *= iterator.next().execute(context);
        } while(iterator.hasNext());
        return ret;
    }
}
