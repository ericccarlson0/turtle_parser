package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AskNode implements ParserNode {
    private List<ParserNode> myNodes;
    private ParserNode myExecute;
    private boolean myNodesFull;

    public AskNode(){
        myNodes = new ArrayList<>();
    }
    @Override
    public void addNode(ParserNode node) {
        System.out.println("ADDING THIS MF NODE " + node);
        if(myNodesFull){
            myExecute = node;
            return;
        }
        if(node.typeOfNode().equals(NodeType.LIST_END)){
            myNodesFull = true;
            return;
        }
        myNodes.add(node);
    }

    @Override
    public double execute(TurtleContext context) {
        System.out.println("VICTORY " + context.getActiveTurtles());
        List<Double> activeTurtles = new ArrayList<>();
        for(ParserNode pn : myNodes){
            activeTurtles.add(pn.execute(context));
        }
        Collections.sort(activeTurtles);
        context.getData().createTurtles(activeTurtles.get(activeTurtles.size()-1));
        List<Double> previousActives = context.getActiveTurtles();
        context.clearActiveTurtles();
        context.addActiveTurtles(activeTurtles);
        System.out.println("VICTORY " + context.getActiveTurtles());
        double ret = myExecute.execute(context);
        context.clearActiveTurtles();
        context.addActiveTurtles(previousActives);
        System.out.println("VICORY " + context.getActiveTurtles());
        return ret;
    }

    @Override
    public boolean isComplete() {
        return myExecute != null;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.TELL;
    }
}
