package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.nodes.MultipleExecutionNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that represents a constant numerical value
 *
 * @author Mariusz Derezinski-Choo
 */
public class ConstantNode extends MultipleExecutionNode {
    private double myValue;

    /**
     * Construct a constant
     * @param value the numerical value of this constant
     */
    public ConstantNode(double value){
        myValue = value;
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        return myValue;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "" + myValue;
    }
}
