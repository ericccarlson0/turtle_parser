package parserModel.control;

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
        double lastValue = 0;
        while(myForNode.execute() != 0){
            lastValue = myBodyNode.execute();
        }
        return lastValue;
    }

    public boolean isComplete() {
        return myBodyNode != null;
    }

}
