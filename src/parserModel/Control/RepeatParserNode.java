package parserModel.Control;

import parserModel.CommandParserNode;

public class RepeatParserNode extends CommandParserNode {
    private CommandParserNode myTimesNode;
    private CommandParserNode executeNode;

    @Override
    public void addNode(CommandParserNode node) {
        if(myTimesNode == null){
            myTimesNode = node;
        } else if(executeNode == null){
            executeNode = node;
        }
        //FIXME: throw exception
    }

    @Override
    public double execute() {
        double returnValue = 0;
        for(int i = 0; i < myTimesNode.execute(); i++){
            returnValue = executeNode.execute();
        }
        return returnValue;
    }

    @Override
    public boolean isComplete() {
        return executeNode != null;
    }
}
