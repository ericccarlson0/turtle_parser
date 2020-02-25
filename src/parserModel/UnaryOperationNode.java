package parserModel;

public abstract class UnaryOperationNode extends CommandParserNode {
    protected CommandParserNode myArgumentNode;

    public void addNode(CommandParserNode node) {
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
