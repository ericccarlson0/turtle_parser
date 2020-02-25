package parserModel;

public class ListEndNode extends ParserNode{

    @Override
    public void addNode(CommandParserNode node) {
        //throw exception
    }

    @Override
    public double execute() {
        return 0;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.LISTEND;
    }
}
