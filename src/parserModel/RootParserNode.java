package parserModel;

import java.util.ArrayList;

public class RootParserNode extends ParserNode {

    public RootParserNode() {
        complete = false;
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
