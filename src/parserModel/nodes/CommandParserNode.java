package parserModel.nodes;

import parserModel.nodes.ParserNode;

public abstract class CommandParserNode extends ParserNode {
  public final NodeType typeOfNode(){
    return ParserNode.NodeType.SIMPLE;
  }
}
