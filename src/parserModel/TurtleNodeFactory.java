package parserModel;

import parserModel.BooleanNodes.*;
import parserModel.Control.RepeatParserNode;
import parserModel.MathNodes.*;
import parserModel.TurtleNodes.*;

public class CommandFactory {

    public CommandFactory(){ }

    /**
     * This is a huge case statement that turns 'identifier' strings into various instances of
     * ParserNode sub-classes
     * @param identifier    A particular string associated with a particular type of ParserNode.
     * @return              Returns subclass of ParserNode.
     */
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
                return new SumNode();
            case "Difference":
                return new DifferenceNode();
            case "Product":
                return new ProductNode();
            case "Quotient":
                return new QuotientNode();
            case "Remainder":
                return new RemainderNode();
            case "Random":
                return new RandomNode();
            case "Minus":
                return new MinusNode();
            case "Sine":
                return new SineNode();
            case "Cosine":
                return new CosineNode();
            case "Tangent":
                return new TangentNode();
            case "ArcTangent":
                return new ArctanNode();
            case "NaturalLog":
                return new LogNode();
            case "Power":
                return new PowNode();
            case "Pi":
                return new PiNode();

            case "LessThan":
                return new LessNode();
            case "GreaterThan":
                return new GreaterNode();
            case "Equal":
                return new EqualNode();
            case "NotEqual":
                return new NotEqualNode();
            case "And":
                return new AndNode();
            case "Or":
                return new OrCommand();
            case "Not":
                return new NotNode();
            case "DoTimes":
                return new RepeatParserNode();
            case "For":
                return new ForParserNode();
        }
        return null;
    }
}
