package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

/**
 * A node that when executed, rotates the turtle
 * so that it faces the direction of the heading,
 * determined by its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class SetHeadingNode extends CommandParserNode {
    private ParserNode myDegrees;

    public SetHeadingNode(){
        super();
        myDegrees = null;
    }

    @Override
    public void addNode(ParserNode node) {
        if (myDegrees == null) {
            myDegrees = node;
        }
    }
    @Override
    public double execute(TurtleContext context) {
        double degrees = myDegrees.execute(context);
        RotateExecutable rotateExecutable = new RotateExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startHeading = td.getHeading();
            td.setHeading(degrees);
            double endHeading = td.getHeading();
            rotateExecutable.addMove((int)id, startHeading, endHeading);
        }
        rotateExecutable.setName(commandNameResource.getString("SetHeading"));

        context.addToQueue(rotateExecutable);
        return degrees;
    }

    @Override
    public boolean isComplete() {
        return myDegrees != null;
    }
}
