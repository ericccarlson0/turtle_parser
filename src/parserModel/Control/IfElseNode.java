package parserModel.Control;

import parserModel.CommandParserNode;

public class IfElseNode extends CommandParserNode {
    private CommandParserNode myConditional;
    private CommandParserNode myIfNode;
    private CommandParserNode myElseNode;

    @Override
    public void addNode(CommandParserNode node) {
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
