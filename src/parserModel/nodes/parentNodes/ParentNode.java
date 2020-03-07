package parserModel.nodes.parentNodes;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.VariableNode;

import java.util.ArrayList;
import java.util.List;

public abstract class ParentNode extends SimpleParserNode {
    protected List<ParserNode> arguments;
    protected int myMinArguments;

    public ParentNode(int minArguments, String text){
        super(text);
        myMinArguments = minArguments;
        arguments = new ArrayList<>();
    }

    @Override
    public double execute(TurtleContext context){
        validateArguments();
        return runValidated(context);
    }
    protected abstract double runValidated(TurtleContext context);

    protected abstract void validateArguments();

    public void addVariable(VariableNode node){
        addNode(node);
    }

    public void addNode(ParserNode node) {
        arguments.add(node);
    }

    public boolean isComplete() {
        return arguments != null && arguments.size() >= myMinArguments;
    }
}
