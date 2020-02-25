package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ParserNode;

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
    public double execute() {
        if(myConditional.execute() != 0.0){
            return myIfNode.execute();
        }
        return myElseNode.execute();
    }

    @Override
    public boolean isComplete() {
        return myElseNode == null;
    }
}
