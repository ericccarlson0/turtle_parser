package parserModel.control;

import parserModel.ParserNode;
import visualizer.VisualContext;

public class ListEndNode extends ParserNode {


    @Override
    public void addNode(ParserNode node) {
        //throw exception
    }

    @Override
    public double execute(VisualContext context) {
        return 0;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.LIST_END;
    }
}
