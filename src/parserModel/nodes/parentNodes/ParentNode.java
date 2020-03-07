package parserModel.nodes.parentNodes;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.VariableNode;
import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class that represents a Parser Node that can accept children
 * that it may execute as a part of running its computations
 *
 * @author Mariusz Derezinski-Choo
 */
public abstract class ParentNode extends SimpleParserNode {
    protected List<ParserNode> arguments;
    protected int myMinArguments;

    /**
     * Construct a parent node, a node that can have children
     * @param minArguments the minimum number of children that must be added
     * @param text the text input associated with this node
     */
    public ParentNode(int minArguments, String text){
        super(text);
        myMinArguments = minArguments;
        arguments = new ArrayList<>();
    }

    /**
     * Execute this node
     * @param context the context within which this command should be executed
     * @return the command-specific return value based on the computations performed
     */
    @Override
    public double execute(TurtleContext context){
        validateArguments();
        return runValidated(context);
    }

    /**
     * run arguments under the precondition that the input has been validated as being correct
     * @param context the context within which the command will be executed
     * @return the command-specific return value based on the computations performed
     */
    protected abstract double runValidated(TurtleContext context);

    /**
     * validate the children to make sure that all necessary commands have been received
     */
    protected abstract void validateArguments();

    @Override
    public void addVariable(VariableNode node){
        addNode(node);
    }

    @Override
    public void addNode(ParserNode node) {
        arguments.add(node);
    }

    @Override
    public boolean isComplete() {
        return arguments != null && arguments.size() >= myMinArguments;
    }
}
