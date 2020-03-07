package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;

public class GroupNode implements ParserNode {
    private ParserNode myExecute;
    private boolean myComplete;

    @Override
    public void addNode(ParserNode node) {
        if(node.equals(SpecialCharacters.GROUP_END)){
            myComplete = true;
            return;
        }
        if(myExecute == null){
            myExecute = node;
        } else{
            myExecute.addNode(node);
        }
    }

    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    @Override
    public double execute(TurtleContext context) {
        return myExecute.execute(context);
    }

    @Override
    public boolean isComplete() {
        return myComplete;
    }
}
