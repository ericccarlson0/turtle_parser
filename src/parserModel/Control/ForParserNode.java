package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ControlParserNode;
import parserModel.ParserNode;

public class ForParserNode extends ControlParserNode {
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
