package parserModel;

public abstract class CommandParserNode extends ParserNode {
  public final NodeType typeOfNode(){
    return ParserNode.NodeType.COMMAND;
  }
}
