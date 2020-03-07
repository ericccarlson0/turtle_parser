package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A Math Node that represents a constant numerical value
 *
 * @author Mariusz Derezinski-Choo
 */
public class ConstantNode extends LeafNode {
    private double myValue;

    /**
     * Construct a constant
     * @param value the numerical value of this constant
     */
    public ConstantNode(String value){
        super(value);
        myValue = Double.parseDouble(value);
    }

    public ConstantNode(double value){
        super(Double.toString(value));
        myValue = value;
    }

    @Override
    public double execute(TurtleContext context) {
        return myValue;
    }
}
