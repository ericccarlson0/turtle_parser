package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

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
        //FIXME: throw exception
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
