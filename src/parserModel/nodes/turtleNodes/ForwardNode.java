package parserModel.nodes.turtleNodes;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

import java.util.ResourceBundle;

/**
 * A node that, when executed, moves the turtle forward.
 *
 * @author Mariusz Derezinski-Choo
 */
public class ForwardNode extends CommandParserNode {
    private ParserNode myLength;

    public ForwardNode(){
        super();
        myLength = null;
    }

    @Override
    public double execute(TurtleContext context) {
        double distance = myLength.execute(context);
        MoveExecutable executable = new MoveExecutable();
        for(double id : context.getActiveTurtles()) {
            System.out.println("an id was found with id: " + id);
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.forward(distance);
            double endX = td.getX();
            double endY = td.getY();
            executable.addMove((int)id, startX, startY, endX, endY);
        }
        executable.setName(commandNameResource.getString("Forward")+" "+ distance);
        context.addToQueue(executable);
        return distance;
    }

    @Override
    public boolean isComplete(){
        return myLength != null;
    }

    @Override
    public void addNode(ParserNode node) { myLength = node; }
}
