package parserModel;

import java.util.ArrayList;
import java.util.List;

public class RootParserNode extends CommandParserNode {
    protected List<CommandParserNode> myChildren;

    public RootParserNode() {
        myChildren = new ArrayList<CommandParserNode>();
    }

    public void addNode(CommandParserNode node) {
        myChildren.add(node);
    }

    public double execute() {

        for (CommandParserNode node : myChildren){
            node.execute();
        }
        return 1;
        //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        for (CommandParserNode node : myChildren){
            ret.append(node);
            ret.append(" ");
        }
        return ret.toString();
    }
}
