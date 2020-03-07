package parserModel.nodes.display;

import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.MultipleExecutionNode;
import parserModel.nodes.ParserNode;

import java.util.List;

public class PenColorNode extends MultipleExecutionNode {
    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> turtles = context.getActiveTurtles();
        TurtleData td = context.getData().turtleData(turtles.get(turtles.size()-1));
        return td.getPenColor();
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
