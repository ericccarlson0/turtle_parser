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

    /**
     * add a child node to the current Node
     * @param node the child node to be added
     */
    @Override
    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    /**
     * Add a variable to the current node to be used as a child
     * @param node the variable to be added
     */
    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    /**
     * execute this Node by iterating through all turtles and creating a move and a clear
     * executable for them
     * @param context the context within which this command should be executed
     * @return double the result of the execution
     */
    @Override
    public double execute(TurtleContext context) {
        MoveExecutable moveExecutable = new MoveExecutable();
        ClearExecutable clearExecutable = new ClearExecutable();
        for(double id : context.getData().getAllTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.clear();
            moveExecutable.addMove((int) id, startX, startY, 0, 0,context.getData().turtleData(id).getPenDown());
            clearExecutable.addMove((int) id);
        }
        context.addToQueue(moveExecutable);
        context.addToQueue(clearExecutable);
        return SUCCESS;
    }

    /**
     * check if the Node is complete (requires no more children)
     * @return a boolean denoting whether the Node is complete
     */
    @Override
    public boolean isComplete() {
        return true;
    }

}
