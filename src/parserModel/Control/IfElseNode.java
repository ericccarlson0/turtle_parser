package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class IfElseNode extends CommandParserNode {
    private ParserNode myConditional;
    private ParserNode myIfNode;
    private ParserNode myElseNode;

    @Override
    public void addNode(ParserNode node) {
        if(myConditional == null){
            myConditional = node;
        } else if (myIfNode == null){
            myIfNode = node;
        } else if(myElseNode == null){
            myElseNode = node;
        } else{
    throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute(VisualContext context) {
        if(myConditional.execute(context) != 0.0){
            return myIfNode.execute(context);
        }
        return myElseNode.execute(context);
    }

    @Override
    public boolean isComplete() {
        return myElseNode == null;
    }
}
