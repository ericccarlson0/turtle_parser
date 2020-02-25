package ParserModel;

import java.util.Collections;
import java.util.List;

public abstract class ParserNode {
    protected enum NodeType {
        LIST,
        GROUP,
        ACTION,
        BOOLEAN,
        MATH,
        CONTROL
    }

    protected boolean complete;
    protected NodeType nodeType;
    protected ParserNode myParent;
    protected List<ParserNode> myChildren;

    public NodeType getType() {
        return nodeType;
    }

    public void setComplete() {
        complete = true;
    }

    public ParserNode getParent() {
        if (! (myParent instanceof RootParserNode) ) {
            return myParent;
        }
        return null;
    }
    public List<ParserNode> getChildren() {
        if (myChildren != null) {
            List<ParserNode> ret = List.copyOf(myChildren);
        }
        return null;
    }

    public abstract void addNode(ParserNode node);
    public abstract double execute();
    public abstract boolean isComplete();
}
