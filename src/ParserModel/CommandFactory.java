package ParserModel;

import ParserModel.BooleanCommands.*;
import ParserModel.Control.RepeatParserNode;
import ParserModel.MathCommands.*;
import ParserModel.TurtleCommands.*;

public class CommandFactory {

    public CommandFactory(){ }

    public ParserNode createCommand(String identifier){
        switch (identifier) {
            case "Forward":
                return new ForwardNode();
            case "Backward":
                return new BackwardNode();
            case "Left":
                return new LeftNode();
            case "Right":
                return new RightNode();
            case "SetHeading":
                return new HeadingNode();
            case "SetTowards":
                return new TowardsNode();
            case "SetPosition":
                return new PositionNode();
            case "PenDown":
                return new PenDownNode();
            case "PenUp":
                return new PenUpNode();
            case "ShowTurtle":
                return new ShowTurtleNode();
            case "HideTurtle":
                return new HideTurtleNode();
            case "Home":
                return new HomeNode();
            case "ClearScreen":
                return new ClearScreenNode();

            case "Sum":
                return new SumCommand();
            case "Difference":
                return new DifferenceCommand();
            case "Product":
                return new ProductCommand();
            case "Quotient":
                return new QuotientCommand();
            case "Remainder":
                return new RemainderCommand();
            case "Random":
                return new RandomCommand();
            case "Minus":
                return new MinusCommand();
            case "Sine":
                return new SineCommand();
            case "Cosine":
                return new CosineCommand();
            case "Tangent":
                return new TangentCommand();
            case "ArcTangent":
                return new ArctanCommand();
            case "NaturalLog":
                return new LogCommand();
            case "Power":
                return new PowCommand();
            case "Pi":
                return new PiCommand();

            case "LessThan":
                return new LessCommand();
            case "GreaterThan":
                return new GreaterCommand();
            case "Equal":
                return new EqualCommand();
            case "NotEqual":
                return new NotEqualCommand();
            case "And":
                return new AndCommand();
            case "Or":
                return new OrCommand();
            case "Not":
                return new NotCommand();
            case "DoTimes":
                return new RepeatParserNode();
            case "For":
                return new ForParserNode();
        }
        return null;
    }
}
