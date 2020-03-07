package parserModel.nodes.parentNodes.unaryOperationNode;

import execution.Executable;
import parserModel.nodes.MultipleExecutionNode;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.VariableNode;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;

public abstract class ParentNode implements ParserNode {
    protected List<ParserNode> arguments;
    protected int myMinArguments;

    protected ParentNode(int minArguments){
        myMinArguments = minArguments;
        arguments = new ArrayList<>();
    }

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
