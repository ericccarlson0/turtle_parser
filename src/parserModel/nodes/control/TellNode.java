package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.BinaryOperationNode;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;
import parserModel.nodes.UnaryOperationNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TellNode implements ParserNode {
    private List<ParserNode> myNodes;
    private boolean isComplete;

    public TellNode(){
        myNodes = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        if(node.typeOfNode() == NodeType.LIST_END){
            isComplete = true;
            return;
        }
        myNodes.add(node);
    }

    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> activeTurtles = new ArrayList<>();
        for(ParserNode pn : myNodes){
            activeTurtles.add(pn.execute(context));
        }
        Collections.sort(activeTurtles);
        context.getData().createTurtle(activeTurtles.get(activeTurtles.size()-1));
        context.clearActiveTurtles();
        context.addActiveTurtles(activeTurtles);
        return 1;
    }

    @Override
    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.TELL;
    }
}
