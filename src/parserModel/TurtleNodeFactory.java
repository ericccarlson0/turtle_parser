package parserModel;

import parserModel.BooleanNodes.*;
import parserModel.Control.RepeatParserNode;
import parserModel.MathNodes.*;
import parserModel.TurtleNodes.*;
import executables.Executable;
import java.util.List;
import parserModel.Control.ForParserNode;
import parserModel.Control.IfElseNode;
import parserModel.Control.IfNode;

import parserModel.TurtleQueries.*;

public class TurtleNodeFactory {

    public TurtleNodeFactory() { }

    /**
     * This is a huge case statement that turns 'identifier' strings into various instances of
     * ParserNode sub-classes
     * @param identifier    A particular string associated with a particular type of ParserNode.
     * @return              Returns subclass of ParserNode.
     */
    public ParserNode createCommand(String identifier, List<Executable> queue){
        switch (identifier) {
            // TURTLE COMMANDS
            case "Forward":
                return new ForwardNode(queue);
            case "Backward":
                return new BackwardNode(queue);
            case "Left":
                return new LTurnNode(queue);
            case "Right":
                return new RTurnNode(queue);
            case "SetHeading":
                // return new HeadingNode(); //FIXME
            case "SetTowards":
                return new TowardsNode(queue);
            case "SetPosition":
                return new SetXYNode(queue);
            case "PenDown":
                return new PenDownNode(queue);
            case "PenUp":
                return new PenUpNode(queue);
            case "ShowTurtle":
                return new ShowNode(queue);
            case "HideTurtle":
                return new HideNode(queue);
            case "Home":
                return new HomeNode(queue);
            case "ClearScreen":
                return new ClearNode(queue);
            // MATH COMMANDS
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

            // BOOLEAN COMMANDS
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
                return new OrNode();
            case "Not":
                return new NotNode();

            // COMPOUND COMMANDS
            case "DoTimes":
                return new ForParserNode();
            case "For":
                return new ForParserNode();
            case "Repeat":
                return new RepeatParserNode();
            case "If":
                return new IfNode();
            case "IfElse":
                return new IfElseNode();

             // TURTLE QUERIES
            case "Xcor":
                return new XCorNode(queue);
            case "Ycor":
                return new YCorNode(queue);
            case "Heading":
                // return new HeadingNode(); FIXME
            case "PenDownNp":
                return new PenDownPNode(queue);
            case "ShowingP":
                return new ShowingPNode(queue);
        }
        return null;
    }
}
