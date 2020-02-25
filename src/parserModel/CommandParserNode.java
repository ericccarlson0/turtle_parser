package parserModel;


public abstract class CommandParserNode extends ParserNode{

  @Override
  public final NodeType typeOfNode(){
    return ParserNode.NodeType.COMMAND;
  }

}
