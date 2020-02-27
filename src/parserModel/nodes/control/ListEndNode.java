package parserModel.nodes.control;

import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

/**
 * A ParserNode that represents the end of a list. this should
 * never be executed, as the end of a list is not a command
 *
 * @author Mariusz Derezinski-Choo
 */
public class ListEndNode extends ParserNode {

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(VisualContext context) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.LIST_END;
    }
}
