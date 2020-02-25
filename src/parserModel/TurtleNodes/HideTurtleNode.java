package parserModel.TurtleCommands;

import parserModel.ParserNode;

public class HideTurtleNode extends ParserNode {
    private static final double EXIT_SUCCESS = 0;

    public HideTurtleNode(){
        super();
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute() {
        System.out.println(toString());
        return EXIT_SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "Hiding Turtle";
    }
}
