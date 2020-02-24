package ParserModel.TurtleCommands;

import ParserModel.ParserNode;

public class RightNode extends ParserNode {
    private ParserNode myRotationNode;

    public RightNode(){
        super();
    }

    @Override
    public void addNode(ParserNode node) {
        if(myRotationNode == null){
            myRotationNode = node;
        } else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute() {
        double degreesToRotate = myRotationNode.execute();
        System.out.println(toString());
        //TODO
        return degreesToRotate;
    }

    @Override
    public boolean isComplete() {
        return myRotationNode != null;
    }

    @Override
    public String toString(){
        return "Right" + myRotationNode;
    }
}
