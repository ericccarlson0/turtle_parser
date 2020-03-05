package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import java.util.ArrayList;
import java.util.List;

/**
 * A CommandParserNode that wraps the calling of a user-defined command
 * adding children adds ParserNodes whose return values will
 * be parameters for the command call
 *
 * @author Mariusz Derezinski-Choo
 */
public class CallCommandNode extends CommandParserNode {
    private List<VariableNode> myVariables;
    private List<SetVariableNode> myVariableInitializers;
    private ParserNode myExecuteNode;

    /**
     * construct a CallCommandNode
     * @param variables the variables that need to be set upon calling the command
     * @param execute the Node that should be executed upon calling the command
     */
    public CallCommandNode(List<VariableNode> variables, ParserNode execute){
        myExecuteNode = execute;
        myVariables = new ArrayList<>(variables);
        myVariableInitializers = new ArrayList<>();
    }

    /**
     * Get a copy of this CallCommand, with the same variable parameters
     * and node to execute, but withou the same parameters
     * to call upon execution
     * @return a new copy of this CallCommand with a blank slate of VariableInitializers
     */
    public CallCommandNode copy(){
        return new CallCommandNode(myVariables, myExecuteNode);
    }

    @Override
    public void addNode(ParserNode node) {
            System.out.println("command node: " + this + " adding node " + node);
            SetVariableNode nextSettingNode = new SetVariableNode(myVariables.get(myVariableInitializers.size()));
            nextSettingNode.addNode(node);
            myVariableInitializers.add(nextSettingNode);
    }

    @Override
    public double execute(TurtleContext context) {
        for(SetVariableNode variableSetter : myVariableInitializers){
            variableSetter.execute(context);
        }
        return myExecuteNode.execute(context);
    }

    @Override
    public boolean isComplete() {
        return myVariableInitializers.size() >= myVariables.size();
    }
}
