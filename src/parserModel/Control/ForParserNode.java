package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ControlParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

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

    public double execute(VisualContext context) {
        double lastValue = 0;
        while(myForNode.execute(context) != 0){
            lastValue = myBodyNode.execute(context);
        }
        return lastValue;
    }

    public boolean isComplete() {
        return myBodyNode != null;
    }

}
