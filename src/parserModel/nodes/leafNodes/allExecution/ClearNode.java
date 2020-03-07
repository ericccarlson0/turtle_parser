package parserModel.nodes.leafNodes.allExecution;

import execution.ClearExecutable;
import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.VariableNode;

/**
 * A node that when executed, clears the
 * turtle screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class ClearNode extends SimpleParserNode {
    private static final double SUCCESS = 0.0;

    public ClearNode(String text) {
        super(text);
    }

    @Override
    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    @Override
    public void addVariable(VariableNode node) {

    }

    @Override
    public double execute(TurtleContext context) {
        MoveExecutable moveExecutable = new MoveExecutable();
        ClearExecutable clearExecutable = new ClearExecutable();
        for(double id : context.getData().getAllTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.clear();
            moveExecutable.addMove((int) id, startX, startY, 0, 0);
            clearExecutable.addMove((int) id);
        }
        clearExecutable.setName("ClearScreen");
        context.addToQueue(moveExecutable);
        context.addToQueue(clearExecutable);
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

}
