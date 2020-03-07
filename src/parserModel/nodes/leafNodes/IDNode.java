package parserModel.nodes.turtleQueries;

import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

import java.util.List;

public class IDNode extends CommandParserNode {

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> myActiveTurtles = context.getActiveTurtles();
        return myActiveTurtles.get(myActiveTurtles.size() - 1);
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
