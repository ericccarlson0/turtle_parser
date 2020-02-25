package parserModel.MathCommands;

import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class PiCommand extends CommandParserNode {

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute() {
        return Math.PI;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
