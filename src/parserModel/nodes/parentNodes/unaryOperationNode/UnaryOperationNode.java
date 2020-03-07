package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;
import parserModel.nodes.parentNodes.ParentNode;

/**
 * Defines behavior for a Parent Node that only accepts one input
 *
 * @author Mariusz Derezinski-Choo
 */
public abstract class UnaryOperationNode extends ParentNode {
    /**
     * Construct a UnaryOperationNode
     * @param text the user-inputted text associated with this construction
     */
    public UnaryOperationNode(String text){
        super(1, text);
    }

    @Override
    protected void validateArguments(){
        if(arguments.size() < myMinArguments){
            throw new InsufficientArgumentException();
        }
    }

    @Override
    protected double runValidated(TurtleContext context){
        double returning = 0;
        for(ParserNode node : arguments){
            returning = evaluate(node, context);
        }
        return returning;
    }

    /**
     * Evaluate the node for the given node
     * @param node the node that is passed as an input
     * @param context the context from which data can be fetched
     * @return the double result of the computation/logic performing
     */
    protected abstract double evaluate(ParserNode node, TurtleContext context);
}
