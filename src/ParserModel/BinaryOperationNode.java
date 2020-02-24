package ParserModel;

import ParserModel.ParserNode;

public abstract class BinaryOperationNode extends ParserNode {
    protected ParserNode firstOperand;
    protected ParserNode secondOperand;

    @Override
    public void addNode(ParserNode node) {
        if(firstOperand == null){
            firstOperand = node;
        } else if(secondOperand == null) {
            secondOperand = node;
        } else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean isComplete() {
        return secondOperand != null;
    }
}
