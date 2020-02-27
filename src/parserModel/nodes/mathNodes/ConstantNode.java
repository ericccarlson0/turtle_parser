package parserModel.nodes.mathNodes;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

/**
 * A Math Node that represents a constant numerical value
 *
 * @author Mariusz Derezinski-Choo
 */
public class ConstantNode extends CommandParserNode {
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
    public double execute(VisualContext context) {
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
