package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

public abstract class TurnNode extends CommandParserNode {
    protected ParserNode myRotationNode;

    public TurnNode(){
        super();
        myRotationNode = null;
    }

    @Override
    public void addNode(ParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public double execute(TurtleContext context) {
        double degrees = myRotationNode.execute(context);
        RotateExecutable rotateExecutable = new RotateExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);

            double startHeading = td.getHeading();
            turn(td, degrees);
            double endHeading = td.getHeading();
            //TODO: throw exception
            rotateExecutable.addMove((int)id, startHeading, endHeading);
        }
        context.addToQueue(rotateExecutable);
        return degrees;
    }

    protected abstract void turn(TurtleData td, double degrees);

    public boolean isComplete() {
        return myRotationNode != null;
    }
}