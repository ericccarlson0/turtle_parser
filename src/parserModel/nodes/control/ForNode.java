package parserModel.nodes.control;

import parserModel.exceptions.InvalidLoopStructureException;
import parserModel.exceptions.NonVariableInLoopHeaderException;
import parserModel.nodes.ControlParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.nodes.SpecialCharacters;
import parserModel.nodes.booleanNodes.NotEqualNode;
import parserModel.nodes.mathNodes.ConstantNode;
import parserModel.nodes.mathNodes.SumNode;

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
public class ForNode extends ControlParserNode {
    private VariableNode myVariableNode;
    private List<ParserNode> myLoop;
    private ListParserNode myBodyNode;
    private int stage;

    public ForNode(){
        super();
        myBodyNode = null;
        myLoop = new ArrayList<>();
        stage = 0;
    }

    @Override
    public void addNode(ParserNode node) {
        switch(stage){
            case 0:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                stage++;
                break;
            case 1:
                throw new NonVariableInLoopHeaderException();
            case 2:
                myLoop.add(node);
                if(myLoop.size() >= 3){
                    stage++;
                }
                break;
            case 3:
                if(!node.equals(SpecialCharacters.CLOSE_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                stage++;
                break;
            case 4:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                myBodyNode = new ListParserNode();
                stage++;
                break;
            case 5:
                myBodyNode.addNode(node);
        }
    }

    @Override
    public void addVariable(VariableNode node) {
        if(stage != 1){
            addNode(node);
        } else{
            myVariableNode = node;
            stage++;
        }
    }

    @Override
    public double execute(TurtleContext context) {
        SetVariableNode initializerNode = new SetVariableNode(myVariableNode);
        initializerNode.addNode(new ConstantNode(myLoop.get(0).execute(context)));
        initializerNode.execute(context);

        ParserNode myIteratingNode = new NotEqualNode();
        ParserNode incrementNode = new SetVariableNode(myVariableNode);


        myIteratingNode.addNode(incrementNode);
        myIteratingNode.addNode(new ConstantNode(myLoop.get(1).execute(context)));

        SumNode adder = new SumNode();
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
