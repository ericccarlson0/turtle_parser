package parserModel.nodes.control;

import execution.newExecutables.LeadTurtleExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TellNode implements ParserNode {
    private List<ParserNode> myNodes;
    private boolean isComplete;

    public TellNode(){
        myNodes = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        if (node.typeOfNode() == NodeType.LIST_END){
            isComplete = true;
            return;
        }
        myNodes.add(node);
    }

    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> activeTurtleIds = new ArrayList<>();
        for(ParserNode node : myNodes) {
            activeTurtleIds.add(node.execute(context));
        }
        /*
        double leadId = activeTurtleIds.get(0);
        TurtleData leadData = context.getData().turtleData(leadId);

        LeadTurtleExecutable executable = new LeadTurtleExecutable();
        List summaryList = new ArrayList<Double>();
        summaryList.add(leadId);
        summaryList.addAll(leadData.getSummaryList());
        executable.addArg(summaryList);
        context.addToQueue(executable);
*/
        Collections.sort(activeTurtleIds);
        double currId = activeTurtleIds.get(activeTurtleIds.size()-1);
        context.getData().createTurtles(currId);

        context.clearActiveTurtles();
        context.addActiveTurtles(activeTurtleIds);
        return 1;
    }

    @Override
    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.TELL;
    }
}
