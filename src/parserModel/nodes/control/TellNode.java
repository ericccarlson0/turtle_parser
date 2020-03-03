package parserModel.nodes.control;

import parserModel.TurtleContext;
import parserModel.nodes.BinaryOperationNode;
import parserModel.nodes.ParserNode;
import parserModel.nodes.UnaryOperationNode;

import java.util.List;

public class TellNode extends BinaryOperationNode {


    @Override
    public double execute(TurtleContext context) {
        context.clearActiveTurtles();
        double turtles = operand1.execute(context);
        for(double i = 0; i < turtles; i++){
            context.getData().createTurtle(i);
            context.addActiveTurtles(List.of(i));
        }
        return  operand2.execute(context);
    }
}
