package parserModel.MathCommands;

import parserModel.CommandParserNode;

public class PiCommand extends CommandParserNode {

    @Override
    public void addNode(CommandParserNode node) {
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
