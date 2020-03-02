package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A CommandParserNode that implements the behavior of an
 * if/else tree. the if node is executed
 * if the conditional evaluates to true (nonzero)
 * otherwise the else node is executed
 *
 * @author Mariusz Derezinski-Choo
 */
public class IfElseNode extends CommandParserNode {
    private static final double FALSE = 0.0;

    private ParserNode myConditional;
    private ParserNode myIfNode;
    private ParserNode myElseNode;

    public IfElseNode(){
        super();
        myConditional = null;
        myElseNode = null;
        myIfNode = null;
    }

    @Override
    public void addNode(ParserNode node) {
        if(myConditional == null){
            myConditional = node;
        } else if (myIfNode == null){
            myIfNode = node;
        } else if(myElseNode == null){
            myElseNode = node;
        } else{
    throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute(TurtleContext context) {
        if(myConditional.execute(context) != FALSE){
            return myIfNode.execute(context);
        }
        return myElseNode.execute(context);
    }

    @Override
    public boolean isComplete() {
        return myElseNode == null;
    }
}
