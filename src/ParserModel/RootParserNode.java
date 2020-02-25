package ParserModel;

import java.util.ArrayList;
import java.util.List;

public class RootParserNode extends ParserNode {

    public RootParserNode() {
        complete = false;
        nodeType = NodeType.LIST;
        myParent = null;
        myChildren = new ArrayList<ParserNode>();
    }

    public void addNode(ParserNode node) {
        myChildren.add(node);
    }

    public double execute() {
        for (ParserNode node : myChildren){
            node.execute();
        }
        return 1;
        //FIXME
    }

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
