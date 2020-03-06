package parserModel.nodes;

import parserModel.TurtleContext;
import parserModel.nodes.control.VariableNode;

public enum SpecialCharacters implements ParserNode {
    OPEN_BRACKET,
    CLOSE_BRACKET,
    GROUP_START,
    GROUP_END;

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addVariable(VariableNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public NodeType typeOfNode() {
        return null;
    }
}
