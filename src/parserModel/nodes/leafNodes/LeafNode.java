package parserModel.nodes.leafNodes;

import parserModel.exceptions.UnsupportedParameterAddedException;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;

public abstract class LeafNode extends SimpleParserNode {

    public LeafNode(String text){
        super(text);
    }

    @Override
    public final void addVariable(VariableNode node){
        throw new UnsupportedParameterAddedException();
    }

    @Override
    public final void addNode(ParserNode node) {
        throw new UnsupportedParameterAddedException();
    }


    @Override
    public final boolean isComplete() {
        return true;
    }
}
