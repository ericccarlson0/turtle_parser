package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

import java.util.ArrayList;
import java.util.List;

public class ListParserNode extends CommandParserNode {
    protected List<ParserNode> myChildren;

    public ListParserNode() {
        myChildren = new ArrayList<>();
    }

    public void addNode(ParserNode node) {
        myChildren.add(node);
    }

    public double execute(VisualContext context) {
        double returning = 0.0;
        for (ParserNode node : myChildren){
            returning = node.execute(context);
        }
        return returning;
    }

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
