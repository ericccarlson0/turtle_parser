package parserModel.nodes;

public abstract class ControlParserNode implements ParserNode {
    public final NodeType typeOfNode(){
        return NodeType.LOOP;
    }
}
