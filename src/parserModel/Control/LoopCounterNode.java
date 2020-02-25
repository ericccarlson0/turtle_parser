package parserModel.Control;

import parserModel.*;
import parserModel.BooleanCommands.NotEqualCommand;
import parserModel.MathCommands.SumCommand;

import java.util.ArrayList;
import java.util.List;

public class LoopCounterNode extends CommandParserNode {
    private List<ParserNode> myIterableParameters;
    private VariableNode myVariableNode;
    private ParserNode myIteratingNode;
    private boolean validated;

    public LoopCounterNode(VariableNode variableNode){
        super();
        myVariableNode = variableNode;
        myIterableParameters = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        if(isComplete()){
            System.out.println("loop complete");
        }
        myIterableParameters.add(node);
    }

    @Override
    public double execute() {
        if(! validated){
            System.out.println(myIterableParameters);
            switch(myIterableParameters.size()){
                case 1:
                    validateLoop(0,1,myIterableParameters.get(0).execute() + 1);
                    break;
                case 3:
                    validateLoop(myIterableParameters.get(0).execute() - 1 ,myIterableParameters.get(2).execute() ,myIterableParameters.get(1).execute() + 1);
                    break;
            }
            validated = true;
        }
        return myIteratingNode.execute();
    }

    private void validateLoop(double initialValue, double incrementValue, double endValue){
        SetVariable initializerNode = new SetVariable(myVariableNode);
        initializerNode.addNode(new ConstantNode(initialValue));
        initializerNode.execute();
        myIteratingNode = new NotEqualCommand();


        SumCommand adder = new SumCommand();
        adder.addNode(myVariableNode);
        adder.addNode(new ConstantNode(incrementValue));

        ParserNode incrementNode = new SetVariable(myVariableNode);
        incrementNode.addNode(adder);

        myIteratingNode.addNode(incrementNode);
        myIteratingNode.addNode(new ConstantNode(endValue));
    }

    @Override
    public boolean isComplete() {
        return myIterableParameters.size() > 3;
    }
}
