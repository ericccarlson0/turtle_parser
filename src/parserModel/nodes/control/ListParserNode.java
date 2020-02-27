package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
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

    protected List<ParserNode> myChildren;

    /**
     * Construct a new ListParserNode
     */
    public ListParserNode() {
        myChildren = new ArrayList<>();
    }

    @Override
    public void addNode(ParserNode node) {
        myChildren.add(node);
    }

    @Override
    public double execute(VisualContext context) {
        double returning = DEFAULT_RETURN;
        for (ParserNode node : myChildren){
            returning = node.execute(context);
        }
        return returning;
    }

    @Override
    public boolean isComplete() {
        return true;
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
