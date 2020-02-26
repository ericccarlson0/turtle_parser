package parserModel.nodes;

import parserModel.nodes.ParserNode;

public abstract class ControlParserNode extends ParserNode {
    public final NodeType typeOfNode(){
        return NodeType.LOOP;
    }
}
