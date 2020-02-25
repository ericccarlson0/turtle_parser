package parserModel.MathCommands;

import parserModel.ParserNode;

public class PiCommand extends ParserNode {

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
