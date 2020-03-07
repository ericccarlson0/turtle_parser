package parserModel.nodes.control;

import parserModel.exceptions.InvalidLoopStructureException;
import parserModel.exceptions.NonVariableInLoopHeaderException;
import parserModel.nodes.ControlParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;
import parserModel.nodes.parentNodes.multiOperation.NotEqualNode;
import parserModel.nodes.leafNodes.ConstantNode;
import parserModel.nodes.parentNodes.multiOperation.SumNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A CommandParserNode that implements the behavior of a
 * for loop. the ForBody is repeatedly executed, and
 * the body node is executed as long as the forBody
 * returns true (a nonzero value)
 *
 * @author Mariusz Derezinski-Choo
 */
public class ForNode extends SimpleParserNode {
    private static final int LOOP_HEADER_SIZE = 3;

    private VariableNode myVariableNode;
    private List<ParserNode> myLoop;
    private ListParserNode myBodyNode;
    private AddingStatus status;

    public ForNode(String text){
        super(text);
        myBodyNode = null;
        myLoop = new ArrayList<>();
        status = AddingStatus.FETCH_HEADER_OPEN_BRACKET;
    }

    @Override
    public void addNode(ParserNode node) {
        switch(status){
            case FETCH_HEADER_OPEN_BRACKET:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                status = AddingStatus.FETCH_VARIABLE;
                break;
            case FETCH_VARIABLE:
                throw new NonVariableInLoopHeaderException();
            case FETCH_HEADER_NODES:
                myLoop.add(node);
                if(myLoop.size() >= LOOP_HEADER_SIZE){
                    status = AddingStatus.FETCH_HEADER_CLOSE_BRACKET;
                }
                break;
            case FETCH_HEADER_CLOSE_BRACKET:
                if(!node.equals(SpecialCharacters.CLOSE_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                status = AddingStatus.FETCH_BODY_OPEN_BRACKET;
                break;
            case FETCH_BODY_OPEN_BRACKET:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                myBodyNode = new ListParserNode();
                status = AddingStatus.FETCH_BODY;
                break;
            case FETCH_BODY:
                myBodyNode.addNode(node);
        }
    }

    @Override
    public void addVariable(VariableNode node) {
        if(status != AddingStatus.FETCH_VARIABLE){
            addNode(node);
        } else{
            myVariableNode = node;
            status = AddingStatus.FETCH_HEADER_NODES;
        }
    }

    @Override
    public double execute(TurtleContext context) {
        SetVariableNode initializerNode = new SetVariableNode(myVariableNode);
        initializerNode.addNode(new ConstantNode(myLoop.get(0).execute(context)));
        initializerNode.execute(context);

        ParserNode myIteratingNode = new NotEqualNode("notequal");
        ParserNode incrementNode = new SetVariableNode(myVariableNode);


        myIteratingNode.addNode(incrementNode);
        myIteratingNode.addNode(new ConstantNode(myLoop.get(1).execute(context)));

        SumNode adder = new SumNode("+");
        incrementNode.addNode(adder);
        adder.addNode(myVariableNode);
        adder.addNode(new ConstantNode(myLoop.get(2).execute(context)));


        double lastValue = 0;
        while(myIteratingNode.execute(context) != 0){
            lastValue = myBodyNode.execute(context);
        }
        return lastValue;
    }

    @Override
    public boolean isComplete() {
        return myBodyNode != null && myBodyNode.isComplete();
    }
}
