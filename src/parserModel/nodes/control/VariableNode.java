package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

/**
 * A node that represents a variable. upon execution, the variable value
 * is fetched from global memory
 *
 * @author Mariusz Derezinski-Choo
 */
public class VariableNode extends CommandParserNode {
    private String myVariableName;

    /**
     * construct a variable node
     * @param variableName the name of the variable
     */
    public VariableNode(String variableName){
        myVariableName = variableName;
    }

    /**
     * get the name of this variable, as defined by the user
     * @return the name of the variable
     */
    public String name(){
        return myVariableName;
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(VisualContext context) {
        return GlobalData.getInstance().getVariable(myVariableName);
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
