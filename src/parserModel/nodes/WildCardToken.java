package parserModel.nodes;

import parserModel.TurtleContext;
import parserModel.exceptions.UnidentifiableTokenException;
import parserModel.nodes.leafNodes.LeafNode;

public class WildCardToken extends LeafNode {
    private String myName;

    public WildCardToken(String identifier) {
        super(identifier);
        myName = identifier;
    }

    @Override
    public double execute(TurtleContext context) {
        throw new UnidentifiableTokenException(myName);
    }

    @Override
    public String toString(){
        return myName;
    }
}
