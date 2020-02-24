package ParserModel.MathCommands;

import ParserModel.ParserNode;

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
