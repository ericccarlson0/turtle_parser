package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A node that represents a variable. upon execution, the variable value
 * is fetched from global memory
 *
 * @author Mariusz Derezinski-Choo
 */
public class VariableNode implements ParserNode {
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
    public void addVariable(VariableNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getData().getVariable(myVariableName);
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.VARIABLE;
    }
}
