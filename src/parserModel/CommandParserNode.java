package parserModel;

import executables.Executable;
import java.util.Queue;

public abstract class CommandParserNode extends ParserNode{

  @Override
  public final NodeType typeOfNode(){
    return ParserNode.NodeType.COMMAND;
  }



//    protected boolean complete;
//    protected ParserNode myParent;
//    protected List<ParserNode> myChildren;
//
//    public void setComplete() {
//        complete = true;
//    }
//
//    public ParserNode getParent() {
//        if (! (myParent instanceof RootParserNode) ) {
//            return myParent;
//        }
//        return null;
//    }
//    public List<ParserNode> getChildren() {
//        if (myChildren != null) {
//            List<ParserNode> ret = List.copyOf(myChildren);
//        }
//        return null;
//    }
}
