package parserModel.nodes;

import parserModel.nodes.control.VariableNode;

import java.util.ResourceBundle;

public abstract class CommandParserNode implements ParserNode {
//  public static final String RESOURCE_PATH = "parserModel.nodes.CommandNodeReflection";
//  public static final ResourceBundle commandResource = ResourceBundle.getBundle(RESOURCE_PATH);

  @Override
  public final void addVariable(VariableNode node){
    addNode(node);
  }
  public final NodeType typeOfNode(){
    return NodeType.SIMPLE;
  }
}
