package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.exceptions.InvalidLoopStructureException;
import parserModel.exceptions.NonVariableInLoopHeaderException;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AskNode extends SimpleParserNode {
    private List<ParserNode> myNodes;
    private ParserNode myExecute;
    private boolean myNodesFull;
    private AddingStatus status;

    public AskNode(String text){
        super(text);
        myNodes = new ArrayList<>();
        status = AddingStatus.FETCH_HEADER_OPEN_BRACKET;
    }

    @Override
    public void addNode(ParserNode node) {
        switch(status){
            case FETCH_HEADER_OPEN_BRACKET:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                status = AddingStatus.FETCH_HEADER_NODES;
                break;
            case FETCH_HEADER_NODES:
                if(node.equals(SpecialCharacters.CLOSE_BRACKET)){
                    status = AddingStatus.FETCH_BODY_OPEN_BRACKET;
                    break;
                }
                myNodes.add(node);
                break;
            case FETCH_HEADER_CLOSE_BRACKET:
                if(!node.equals(SpecialCharacters.CLOSE_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                break;
            case FETCH_BODY_OPEN_BRACKET:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new InvalidLoopStructureException();
                }
                myExecute = new ListParserNode();
                status = AddingStatus.FETCH_BODY;
                break;
            case FETCH_BODY:
                System.out.println("adding node: to lister" + node);
                myExecute.addNode(node);
        }
    }

    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    @Override
    public double execute(TurtleContext context) {
        System.out.println("VICTORY " + context.getActiveTurtles());
        List<Double> activeTurtles = new ArrayList<>();
        for(ParserNode pn : myNodes){
            activeTurtles.add(pn.execute(context));
        }
        Collections.sort(activeTurtles);
        context.getData().createTurtles(activeTurtles.get(activeTurtles.size()-1));
        List<Double> previousActives = context.getActiveTurtles();
        context.replaceActiveTurtles(activeTurtles);
        System.out.println("VICTORY " + context.getActiveTurtles());
        double ret = myExecute.execute(context);
        context.replaceActiveTurtles(previousActives);
        System.out.println("VICORY " + context.getActiveTurtles());
        return ret;
    }

    @Override
    public boolean isComplete() {
        return myExecute != null && myExecute.isComplete();
    }
}
