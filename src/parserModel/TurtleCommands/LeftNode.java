package parserModel.TurtleCommands;

import parserModel.ParserNode;

public class LeftNode extends ParserNode {
    private ParserNode leftNode;

    public LeftNode(){
        super();
    }

    @Override
    public void addNode(ParserNode node) {
        if(leftNode == null){
            leftNode = node;
        } else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute() {
        double degreesToTurn = leftNode.execute();
        System.out.println(toString());

        //TODO
        return degreesToTurn;
    }

    @Override
    public boolean isComplete() {
        return leftNode != null;
    }

    @Override
    public String toString(){
        return "Turning Left " + leftNode;
    }
}
