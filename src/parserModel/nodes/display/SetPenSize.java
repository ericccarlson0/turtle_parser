package parserModel.nodes.display;

import parserModel.TurtleContext;
import parserModel.nodes.parentNodes.ParentNode;

public class SetPenSize extends ParentNode {

    protected SetPenSize(String text) {
        super(1, text);
    }

    @Override
    protected double runValidated(TurtleContext context) {
        return 0;
    }

    @Override
    protected void validateArguments() {

    }
}
