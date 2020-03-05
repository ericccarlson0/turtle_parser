package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.nodes.SpecialCharacters;

import java.util.ArrayList;
import java.util.List;

/**
 * A ParserNode that represents a list of commands.
 * the nodes are executed in the order they are added,
 * and the value of the last node is returned
 *
 * @author Mariusz Derezinski-Choo
 */
public class ListParserNode extends CommandParserNode {
    private static final double DEFAULT_RETURN = 0.0;

    private boolean complete;
    protected List<ParserNode> myChildren;

    /**
     * Construct a new ListNode
     */
    public ListParserNode() {
        myChildren = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        if(node.equals(SpecialCharacters.CLOSE_BRACKET)){
            complete = true;
        } else {
            myChildren.add(node);
        }
    }

    @Override
    public double execute(TurtleContext context) {
        double returning = DEFAULT_RETURN;
        for (ParserNode node : myChildren){
            returning = node.execute(context);
        }
        return returning;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (ParserNode node : myChildren){
            ret.append(node);
            ret.append(" ");
        }
        return ret.toString();
    }
}
