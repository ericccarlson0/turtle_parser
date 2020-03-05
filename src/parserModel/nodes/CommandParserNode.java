package parserModel.nodes;

import parserModel.nodes.control.VariableNode;

public abstract class CommandParserNode implements ParserNode {

  @Override
  public final void addVariable(VariableNode node){
    addNode(node);
  }
  public final NodeType typeOfNode(){
    return NodeType.SIMPLE;
  }
}
