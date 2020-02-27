package parserModel.nodes.turtleNodes;

import execution.ForwardExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

/**
 * A node that when executed, moves the turtle forward
 * the value of its child node
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
    public double execute(VisualContext context) {
        double distance = myLength.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();



        td.forward(distance);
        context.getExecutableQueue().add(new ForwardExecutable(distance));
        return distance;
    }

    @Override
    public boolean isComplete(){
        return myLength != null;
    }

    @Override
    public void addNode(ParserNode node) { myLength = node; }
}
