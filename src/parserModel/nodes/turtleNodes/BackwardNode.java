package parserModel.nodes.turtleNodes;

import execution.MoveExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.TurtleData;

import java.util.List;

/**
 * A node that when executed, moves the turtle backward
 * the value of its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class BackwardNode extends CommandParserNode {
    private ParserNode myLength;

    /**
     * Construct a BackwardNode
     */
    public BackwardNode(){
        super();
    }

    @Override
    public double execute(TurtleContext context) {
        double distance = myLength.execute(context);
        MoveExecutable executable = new MoveExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.backward(distance);
            double endX = td.getX();
            double endY = td.getY();
            executable.addArg(List.of(id, startX, startY, endX, endY));
        }
        context.addToQueue(executable);
        return distance;
    }

    @Override
    public boolean isComplete() {
        return myLength != null;
    }

    @Override
    public void addNode(ParserNode node) {
        myLength = node;
    }
}
