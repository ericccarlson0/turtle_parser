package parserModel.nodes.display;

import execution.newExecutables.SetShapeExecutable;
import parserModel.GlobalData;
import parserModel.TurtleContext;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.nodes.UnaryOperationNode;

public class SetShapeNode extends UnaryOperationNode {
    @Override
    public double execute(TurtleContext context) {
        double shapeIndex = myArgumentNode.execute(context);
        //context.getExecutableQueue().add(new SetShapeExecutable(shapeIndex)); FIXME!
        return shapeIndex;
    }
}
