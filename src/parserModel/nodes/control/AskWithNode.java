package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.VariableNode;

import java.util.List;

public class AskWithNode extends SimpleParserNode {

    private ParserNode myConditionNode;
    private ParserNode myExecuteNode;

    public AskWithNode(String text){
        super(text);
        myConditionNode=null;
        myExecuteNode=null;
    }
    @Override
    public void addNode(ParserNode node) {
        if(myConditionNode == null){
            myConditionNode = node;
        } else if(myExecuteNode == null){
            myExecuteNode = node;
        }
    }

    @Override
    public void addVariable(VariableNode node) {

    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> previousTurtles = context.getActiveTurtles();
        double ret = 0.0;
        for(double id : context.getData().getAllTurtles()){
            context.setWorkingTurtle(id);
            if(myConditionNode.execute(context) != 0.0){

                ret = myExecuteNode.execute(context);
            }
        }
        context.replaceActiveTurtles(previousTurtles);
        return ret;
    }

    @Override
    public boolean isComplete() {
        return myExecuteNode != null;
    }
}
