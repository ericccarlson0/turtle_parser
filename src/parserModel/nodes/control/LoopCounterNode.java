package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.nodes.booleanNodes.NotEqualNode;
import parserModel.nodes.mathNodes.ConstantNode;
import parserModel.nodes.mathNodes.SumNode;
import visualizer.VisualContext;
import java.util.ArrayList;
import java.util.List;

/**
 * A Node that represents counting through a loop
 * the value of the variable is incremented by the
 * specified value upon each increment
 *
 * @author Mariusz Derezinski-Choo
 */
public class LoopCounterNode extends CommandParserNode {
    private static final int SIMPLE_LOOP = 1;
    private static final int COMPLEX_LOOP = 3;

    private List<ParserNode> myIterableParameters;
    private VariableNode myVariableNode;
    private ParserNode myIteratingNode;
    private boolean validated;

    /**
     * construct a loop counter
     * @param variableNode the variable that is to be incremented
     */
    public LoopCounterNode(VariableNode variableNode){
        super();
        myVariableNode = variableNode;
        myIterableParameters = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        myIterableParameters.add(node);
    }

    @Override
    public double execute(VisualContext context) {
        if(! validated){
            switch(myIterableParameters.size()){
                case SIMPLE_LOOP:
                    validateLoop(0,1,myIterableParameters.get(0).execute(context) + 1).execute(context);
                    break;
                case COMPLEX_LOOP:
                    validateLoop(myIterableParameters.get(0).execute(context) - 1 ,myIterableParameters.get(2).execute(context) ,myIterableParameters.get(1).execute(context) + 1).execute(context);
                    break;
            }
            validated = true;
        }
        return myIteratingNode.execute(context);
    }

    @Override
    public boolean isComplete() {
        return myIterableParameters.size() == COMPLEX_LOOP || myIterableParameters.size() == SIMPLE_LOOP;
    }

    private ParserNode validateLoop(double initialValue, double incrementValue, double endValue){
        SetVariable initializerNode = new SetVariable(myVariableNode);
        initializerNode.addNode(new ConstantNode(initialValue));
        myIteratingNode = new NotEqualNode();


        SumNode adder = new SumNode();
        adder.addNode(myVariableNode);
        adder.addNode(new ConstantNode(incrementValue));

        ParserNode incrementNode = new SetVariable(myVariableNode);
        incrementNode.addNode(adder);

        myIteratingNode.addNode(incrementNode);
        myIteratingNode.addNode(new ConstantNode(endValue));

        return initializerNode;
    }
}
