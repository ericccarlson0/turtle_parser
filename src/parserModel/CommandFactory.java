package parserModel;

import executables.Executable;
import java.util.List;
import parserModel.BooleanCommands.*;
import parserModel.Control.RepeatParserNode;
import parserModel.MathCommands.*;
import parserModel.TurtleCommands.*;
import parserModel.TurtleQueries.*;

public class CommandFactory {

    public CommandFactory(){ }

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
                return new SetHeadingNode(queue);
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
            // BOOLEAN COMMANDS
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
            // COMPOUND COMMANDS
            case "DoTimes":
                return new RepeatParserNode();
            case "For":
                return new ForParserNode();

             // TURTLE QUERIES
            case "Xcor":
                return new XCorNode(queue);
            case "Ycor":
                return new YCorNode(queue);
            case "Heading":
                return new HeadingNode(queue);
            case "PenDownNp":
                return new PenDownPNode(queue);
            case "ShowingP":
                return new ShowingPNode(queue);
        }
        return null;
    }
}
