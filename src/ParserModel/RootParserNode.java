package ParserModel;

import java.util.ArrayList;
import java.util.List;

public class RootParserNode extends ParserNode {
    private List<ParserNode> myNodes;

    public RootParserNode() {
        myNodes = new ArrayList<>();
    }

    public void addNode(ParserNode node) {
        myNodes.add(node);
    }

    public double execute() {
        for (ParserNode node : myNodes){
            node.execute();
        }
        return 1; //FIXME
    }

    public boolean isComplete() {
        return false; //FIXME
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (ParserNode node : myNodes){
            ret.append(node);
            ret.append(" ");
        }
        return ret.toString();
    }
}
