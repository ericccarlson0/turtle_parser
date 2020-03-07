package parserModel.nodes.leafNodes;

import parserModel.exceptions.UnsupportedParameterAddedException;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;

/**
 * An abstract class that handles much of the implementation of a SimpleParserNode
 * for a node that cannot accept any children, hence being a "leaf" in the
 * parser's abstract syntax tree
 *
 * @author Mariusz Derezinski-Choo
 */
public abstract class LeafNode extends SimpleParserNode {

    /**
     * A Construct a Leaf Node
     * @param text the user-inputted text associated with this call to a Leaf Node
     */
    public LeafNode(String text){
        super(text);
    }

    @Override
    public final void addVariable(VariableNode node){
        addNode(node);
    }

    @Override
    public final void addNode(ParserNode node) {
        throw new UnsupportedParameterAddedException(myEnteredText, node.toString());
    }

    @Override
    public final boolean isComplete() {
        return true;
    }
}
