package parserModel.nodes.turtleQueries;

import parserModel.TurtleContext;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

public class TurtlesNode extends CommandParserNode {

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getData().getAllTurtles().size();
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
