package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

/**
 * A Node that represents repeating the
 * same statement repeatedly
 *
 * @author Mariusz Derezinski-Choo
 */
public class RepeatParserNode extends CommandParserNode {
    private ParserNode myTimesNode;
    private ParserNode executeNode;

    @Override
    public void addNode(ParserNode node) {
        if(myTimesNode == null){
            myTimesNode = node;
        } else if(executeNode == null){
            executeNode = node;
        }
    }

    @Override
    public double execute(VisualContext context) {
        double returnValue = 0;
        for(int i = 0; i < myTimesNode.execute(context); i++){
            returnValue = executeNode.execute(context);
        }
        return returnValue;
    }

    @Override
    public boolean isComplete() {
        return executeNode != null;
    }
}
