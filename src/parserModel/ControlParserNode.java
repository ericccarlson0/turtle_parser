package parserModel;

public abstract class ControlParserNode extends ParserNode {
    public final NodeType typeOfNode(){
        return NodeType.LOOP;
    }
}
