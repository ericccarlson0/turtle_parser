package parserModel;

public class SetVariable extends CommandParserNode{
    private VariableNode myVariableNode;
    private ParserNode myAssignmentNode;

    public SetVariable(VariableNode node){
        myVariableNode = node;
    }

    @Override
    public void addNode(ParserNode node) {
        if(myAssignmentNode == null){
            myAssignmentNode = node;
        } //FIXME
    }

    @Override
    public double execute() {
        return 0; //FIXME
    }

    @Override
    public boolean isComplete() {
        return myAssignmentNode != null;
    }
}
