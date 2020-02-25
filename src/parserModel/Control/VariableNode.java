package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import parserModel.Variables;

public class VariableNode extends CommandParserNode {
    private String myVariableName;

    public VariableNode(String variableName){
        myVariableName = variableName;
    }

    public String name(){
        return myVariableName;
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute() {
        return new Variables().getVariable(myVariableName);
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
