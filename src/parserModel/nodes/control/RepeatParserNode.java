package parserModel.nodes.control;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;

/**
 * A Node that represents repeating the
 * same statement repeatedly
 *
 * @author Mariusz Derezinski-Choo
 */
public class RepeatParserNode extends SimpleParserNode {
    private ParserNode myTimesNode;
    private ListParserNode myExecuteNode;
    private int state;

    public RepeatParserNode(String text){
        super(text);
        myExecuteNode = new ListParserNode();
    }

    @Override
    public void addNode(ParserNode node) {
        switch(state){
            case 0:
                myTimesNode = node;
                state++;
                break;
            case 1:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    //TODO: throw exception
                }
                state++;
                break;
            case 2:
                myExecuteNode.addNode(node);
        }
    }

    @Override
    public void addVariable(VariableNode node) {
        addNode(node);
    }

    @Override
    public double execute(TurtleContext context) {
        double returnValue = 0;
        double times = myTimesNode.execute(context);
        System.out.println("times node is: " + myTimesNode);
        System.out.println("repeating" + times + "number of times");
        for(int i = 0; i < times; i++){
            returnValue = myExecuteNode.execute(context);
        }
        return returnValue;
    }

    @Override
    public boolean isComplete() {
        return myExecuteNode.isComplete();
    }
}
