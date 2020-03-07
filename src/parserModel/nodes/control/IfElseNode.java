package parserModel.nodes.control;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;

import java.util.List;

/**
 * A CommandParserNode that implements the behavior of an
 * if/else tree. the if node is executed
 * if the conditional evaluates to true (nonzero)
 * otherwise the else node is executed
 *
 * @author Mariusz Derezinski-Choo
 */
public class IfElseNode extends SimpleParserNode {
    private static final double FALSE = 0.0;

    private ParserNode myIfNode;
    private ListParserNode myTrueNode;
    private ListParserNode myFalseNode;
    private int state;

    public IfElseNode(String text){
        super(text);
        myTrueNode = new ListParserNode();
        myFalseNode = new ListParserNode();
    }

    @Override
    public void addNode(ParserNode node) {
        switch(state){
            case 0:
                myIfNode = node;
                state++;
                break;
            case 1:
            case 3:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    //TODO: throw exception
                }
                state++;
                break;
            case 2:
                myIfNode.addNode(node);
                if(myIfNode.isComplete()){
                    state++;
                }
                break;
            case 4:
                myFalseNode.addNode(node);
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
                myTrueNode.execute(context);
            } else{
                myFalseNode.execute(context);
            }
        }
        context.replaceActiveTurtles(activeTurtles);
        return 1.0; //TODO: FIXME
    }

    @Override
    public boolean isComplete() {
        return myFalseNode.isComplete();
    }
}
