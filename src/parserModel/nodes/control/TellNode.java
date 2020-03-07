package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TellNode extends SimpleParserNode {
    private List<ParserNode> myNodes;
    private boolean isComplete;
    private int stage;

    public TellNode(String text){
        super(text);
        myNodes = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        switch(stage){
            case 0:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    //throw execption
                }
                stage++;
                break;
            case 1:
                if(node.equals(SpecialCharacters.CLOSE_BRACKET)){
                    stage++;
                    isComplete = true;
                }
                else{
                    myNodes.add(node);
                }
                break;
            case 2:
                //throw exception

        }
    }

    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> activeTurtleIds = new ArrayList<>();
        for(ParserNode node : myNodes) {
            activeTurtleIds.add(node.execute(context));
        }
        Collections.sort(activeTurtleIds);
        double currId = activeTurtleIds.get(activeTurtleIds.size()-1);
        context.getData().createTurtles(currId);
        context.replaceActiveTurtles(activeTurtleIds);
        return 1;
    }

    @Override
    public boolean isComplete() {
        return isComplete;
    }

}
