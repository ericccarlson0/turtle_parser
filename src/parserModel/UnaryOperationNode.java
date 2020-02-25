package parserModel;

public abstract class UnaryOperationNode extends CommandParserNode {
    protected ParserNode myArgumentNode;

    public void addNode(ParserNode node) {
        if (myArgumentNode == null){
            myArgumentNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean isComplete() {
        return myArgumentNode != null;
    }
}
