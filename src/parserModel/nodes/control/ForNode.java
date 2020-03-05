package parserModel.nodes.control;

import parserModel.nodes.ControlParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A CommandParserNode that implements the behavior of a
 * for loop. the ForBody is repeatedly executed, and
 * the body node is executed as long as the forBody
 * returns true (a nonzero value)
 *
 * @author Mariusz Derezinski-Choo
 */
public class ForNode extends ControlParserNode {
    private ParserNode myForNode;
    private ParserNode myBodyNode;

    public ForNode(){
        super();
        myBodyNode = null;
        myForNode = null;
    }

    @Override
    public void addNode(ParserNode node) {
        if (myForNode == null){
            myForNode = node;
        } else if (myBodyNode == null){
            myBodyNode = node;
        }
    }

    @Override
    public double execute(TurtleContext context) {
        double lastValue = 0;
        while(myForNode.execute(context) != 0){
            lastValue = myBodyNode.execute(context);
        }
        return lastValue;
    }

    @Override
    public boolean isComplete() {
        return myBodyNode != null;
    }

}
