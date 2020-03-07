package parserModel.nodes.turtleNodes;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

/**
 * A node that when executed, Sets the X and
 * Y coordinates of the turtle to the values
 * returned by the child nodes
 *
 * @author Mariusz Derezinski-Choo
 */
public class SetXYNode extends CommandParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;

    public SetXYNode(){
        super();
        myXNode = null;
        myYNode = null;
    }

    @Override
    public void addNode(ParserNode node) {
        if (myXNode == null) {
            myXNode = node;
        } else if (myYNode == null) {
            myYNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public double execute(TurtleContext context) {
        double endX = myXNode.execute(context);
        double endY = myYNode.execute(context);
        MoveExecutable executable = new MoveExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.setX(endX);
            td.setY(endY);
            executable.addMove((int)id, startX, startY, endX, endY);
        }
        executable.setName(commandNameResource.getString("SetPosition"));

        context.addToQueue(executable);
        return endX; //?
    }

    @Override
    public boolean isComplete() {
        return myYNode != null;
    }
}
