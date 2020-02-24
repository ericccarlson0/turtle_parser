package ParserModel.MathCommands;

import ParserModel.ParserNode;

public abstract class UnaryOperationNode extends ParserNode {
    protected ParserNode myArgumentNode;

    @Override
    public void addNode(ParserNode node) {
        if(myArgumentNode == null){
            myArgumentNode = node;
        } else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean isComplete() {
        return myArgumentNode != null;
    }
}
