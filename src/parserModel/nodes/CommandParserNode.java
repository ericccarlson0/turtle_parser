package parserModel.nodes;

public abstract class CommandParserNode implements ParserNode {
  public final NodeType typeOfNode(){
    return NodeType.SIMPLE;
  }
}
