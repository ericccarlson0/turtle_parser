package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

import java.util.ArrayList;
import java.util.List;

public class CallCommandNode extends CommandParserNode {
    private List<VariableNode> myVariables;
    private List<SetVariable> myVariableInitializers;
    private ParserNode myExecuteNode;

    public CallCommandNode(List<VariableNode> variables, ParserNode execute){
        myExecuteNode = execute;
        myVariables = variables;
        myVariableInitializers = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        SetVariable nextSettingNode = new SetVariable(myVariables.get(myVariableInitializers.size()));
        nextSettingNode.addNode(node);
        myVariableInitializers.add(nextSettingNode);
    }

    @Override
    public double execute(VisualContext context) {
        for(SetVariable variableSetter : myVariableInitializers){
            variableSetter.execute(context);
        }
        myVariableInitializers = new ArrayList<>();
        return myExecuteNode.execute(context);
    }

    @Override
    public boolean isComplete() {
        return myVariableInitializers.size() >= myVariables.size();
    }
}
