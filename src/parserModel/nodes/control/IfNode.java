package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;

import java.util.List;

/**
 * A CommandParserNode that implements the behavior of an
 * if tree. the if node is executed
 * if the conditional evaluates to true (nonzero)
 * otherwise nothing occurs and 0 is returned
 *
 * @author Mariusz Derezinski-Choo
 */
public class IfNode extends SimpleParserNode {
    private static final double FALSE = 0.0;
    private static final double RETURN_FALSE = 0.0;

    private ParserNode myIfNode;
    private ListParserNode myListNode;
    private int state;

    public IfNode(String text) {
        super(text);
    }

    @Override
    public void addNode(ParserNode node) {
        switch(state){
            case 0:
                myIfNode = node;
                myListNode = new ListParserNode();
                state++;
                break;
            case 1:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    //TODO: throw exception
                }
                state++;
                break;
            case 2:
                myListNode.addNode(node);
        }
    }

    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> activeTurtles = context.getActiveTurtles();
        for(double id : activeTurtles){
            context.setWorkingTurtle(id);
            if(myIfNode.execute(context) != FALSE){
                myListNode.execute(context);
            }
        }
        context.replaceActiveTurtles(activeTurtles);
        return RETURN_FALSE;
    }

    @Override
    public boolean isComplete() {
        return myListNode != null && myListNode.isComplete();
    }
}
