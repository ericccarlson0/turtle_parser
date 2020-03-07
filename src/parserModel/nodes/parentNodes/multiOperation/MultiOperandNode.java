package parserModel.nodes.parentNodes.multiOperation;

import parserModel.nodes.parentNodes.ParentNode;

public abstract class MultiOperandNode extends ParentNode {
    public MultiOperandNode(String text){
        super(2, text);
    }
}
