package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

import java.util.List;

public class AskWithNode extends CommandParserNode {

    private ParserNode myConditionNode;
    private ParserNode myExecuteNode;

    @Override
    public void addNode(ParserNode node) {
        if(myConditionNode == null){
            myConditionNode = node;
        } else if(myExecuteNode == null){
            myExecuteNode = node;
        }
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> previousTurtles = context.getActiveTurtles();
        context.clearActiveTurtles();
        double ret = 0.0;
        for(double id : context.getData().getAllTurtles()){
            context.addActiveTurtles(List.of(id));
            if(myConditionNode.execute(context) != 0.0){

                ret = myExecuteNode.execute(context);
            }
            context.clearActiveTurtles();
        }
        context.addActiveTurtles(previousTurtles);
        return ret;
    }

    @Override
    public boolean isComplete() {
        return myExecuteNode != null;
    }
}
