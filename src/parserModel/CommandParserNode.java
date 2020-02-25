package parserModel;

import executables.Executable;
import java.util.Queue;

public abstract class CommandParserNode extends ParserNode{

  @Override
  public final NodeType typeOfNode(){
    return ParserNode.NodeType.COMMAND;
  }

}
