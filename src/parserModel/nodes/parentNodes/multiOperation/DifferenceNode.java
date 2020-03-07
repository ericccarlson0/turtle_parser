package parserModel.nodes.parentNodes.multiOperation;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A Math Node that computes the difference of its children
 *
 * @author Mariusz Derezinski-Choo
 */
public class DifferenceNode extends MultiOperandNode {
    public DifferenceNode(String text) {
        super(text);
    }

    protected void validateArguments(){
        if(arguments.size() < myMinArguments){
            throw new InsufficientArgumentException();
        }
    }

    @Override
    public double runValidated(TurtleContext context) {
        Iterator<ParserNode> iterator = arguments.iterator();
        double returning = iterator.next().execute(context);
        while(iterator.hasNext()){
            returning -= iterator.next().execute(context);
        }
        return returning;
    }
}