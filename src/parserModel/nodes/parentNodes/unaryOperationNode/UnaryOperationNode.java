package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;
import parserModel.nodes.parentNodes.ParentNode;

public abstract class UnaryOperationNode extends ParentNode {
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

    protected abstract double evaluate(ParserNode node, TurtleContext context);
}
