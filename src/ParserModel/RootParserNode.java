package ParserModel;

import java.util.ArrayList;
import java.util.List;

public class RootParserNode extends ParserNode{
    private List<ParserNode> myNodes;

    public RootParserNode(){
        myNodes = new ArrayList<>();
    }


    @Override
    public void addNode(ParserNode node) {
        myNodes.add(node);
    }

    @Override
    public double execute() {
        for(ParserNode node : myNodes){
            node.execute();
        }
        return 1; //FIXME
    }

    @Override
    public int numberOfNodes() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for(ParserNode node : myNodes){
            ret.append(node).append("\n");
        }
        return ret.toString();
    }
}
