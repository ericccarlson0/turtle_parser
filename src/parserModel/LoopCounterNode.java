package parserModel;

import java.util.ArrayList;
import java.util.List;

public class LoopCounterNode extends CommandParserNode{
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
            switch(myIterableParameters.size()){
                case 1:
                    SetVariable initializerNode = new SetVariable(myVariableNode);
                    initializerNode.addNode(new ConstantNode(1.0));
                    initializerNode.execute();
                    myVariableNode = new RootParserNode();
            }
        }
    }

    @Override
    public boolean isComplete() {
        return myIterableParameters.size() > 3;
    }
}
