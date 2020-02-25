package parserModel;

public class ForParserNode extends ParserNode {
    private ParserNode myForNode;
    private ParserNode myBodyNode;

    public void addNode(ParserNode node) {
        if (myForNode == null){
            myForNode = node;
        } else if (myBodyNode == null){
            myBodyNode = node;
        }
    }

    public double execute() {
        //TODO
        return 0;
    }

    public boolean isComplete() {
        return myBodyNode != null;
    }

}
