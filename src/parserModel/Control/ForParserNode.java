package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ControlParserNode;

public class ForParserNode extends ControlParserNode {
    private CommandParserNode myForNode;
    private CommandParserNode myBodyNode;

    public void addNode(CommandParserNode node) {
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
