package parserModel.nodes;

import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.booleanNodes.*;
import parserModel.nodes.control.*;
import parserModel.nodes.mathNodes.*;
import parserModel.nodes.turtleNodes.*;

import parserModel.nodes.turtleQueries.*;

public class CommandFactory {

    public CommandFactory() { }

    /**
     * This is a huge case statement that turns 'identifier' strings into various instances of
     * ParserNode sub-classes
     * @param identifier    A particular string associated with a particular type of ParserNode.
     * @return              Returns subclass of ParserNode.
     */
    public ParserNode createCommand(String identifier){
        switch (identifier) {
            // TURTLE COMMANDS
            case "Forward":
                return new ForwardNode();
            case "Backward":
                return new BackwardNode();
            case "Left":
                return new LTurnNode();
            case "Right":
                return new RTurnNode();
            case "SetHeading":
                return new SetHeadingNode();
            case "SetTowards":
                return new TowardsNode();
            case "SetPosition":
                return new SetXYNode();
            case "PenDown":
                return new PenDownNode();
            case "PenUp":
                return new PenUpNode();
            case "ShowTurtle":
                return new ShowNode();
            case "HideTurtle":
                return new HideNode();
            case "Home":
                return new HomeNode();
            case "ClearScreen":
                return new ClearNode();
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
            case "For":
                return new ForParserNode();
            case "MakeVariable":

            case "Repeat":
                return new RepeatParserNode();
            case "If":
                return new IfNode();
            case "IfElse":
                return new IfElseNode();
            case "MakeUserInstruction":
                return new UserDefinedCommandNode();

             // TURTLE QUERIES
            case "Xcor":
                return new XCorNode();
            case "Ycor":
                return new YCorNode();
            case "Heading":
                // return new HeadingNode(); FIXME
            case "PenDownNp":
                return new PenDownPNode();
            case "ShowingP":
                return new ShowingPNode();
        }
        return GlobalData.getInstance().getCommand(identifier);
    }
}
