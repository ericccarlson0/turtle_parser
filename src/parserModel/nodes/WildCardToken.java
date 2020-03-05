package parserModel.nodes;

import parserModel.TurtleContext;
import parserModel.nodes.control.VariableNode;

public class WildCardToken implements ParserNode {
    private String myName;

    public WildCardToken(String identifier) {
        myName = identifier;
    }

    @Override
    public void addNode(ParserNode node) {

    }

    @Override
    public void addVariable(VariableNode node) {

    }

    @Override
    public double execute(TurtleContext context) {
        return 0;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public NodeType typeOfNode() {
        return null;
    }

    @Override
    public String toString(){
        return myName;
    }
}
