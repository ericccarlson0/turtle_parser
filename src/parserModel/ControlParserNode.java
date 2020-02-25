package parserModel;

public abstract class ControlParserNode extends ParserNode {

    @Override
    public final NodeType typeOfNode(){
        return NodeType.LOOP;
    }
}
