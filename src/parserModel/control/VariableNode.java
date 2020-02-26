package parserModel.control;

import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;

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
        return GlobalData.getInstance().getVariable(myVariableName);
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
