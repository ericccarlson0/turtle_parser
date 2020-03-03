package parserModel.nodes;

import parserModel.GlobalData;
import parserModel.TurtleContext;
import parserModel.nodes.booleanNodes.AndNode;
import parserModel.nodes.booleanNodes.EqualNode;
import parserModel.nodes.booleanNodes.GreaterNode;
import parserModel.nodes.booleanNodes.LessNode;
import parserModel.nodes.booleanNodes.NotEqualNode;
import parserModel.nodes.booleanNodes.NotNode;
import parserModel.nodes.booleanNodes.OrNode;
import parserModel.nodes.control.AskNode;
import parserModel.nodes.control.ForParserNode;
import parserModel.nodes.control.IfElseNode;
import parserModel.nodes.control.IfNode;
import parserModel.nodes.control.RepeatParserNode;
import parserModel.nodes.control.SetVariable;
import parserModel.nodes.control.TellNode;
import parserModel.nodes.control.UserDefinedCommandNode;
import parserModel.nodes.mathNodes.ArctanNode;
import parserModel.nodes.mathNodes.CosineNode;
import parserModel.nodes.mathNodes.DifferenceNode;
import parserModel.nodes.mathNodes.LogNode;
import parserModel.nodes.mathNodes.MinusNode;
import parserModel.nodes.mathNodes.PiNode;
import parserModel.nodes.mathNodes.PowNode;
import parserModel.nodes.mathNodes.ProductNode;
import parserModel.nodes.mathNodes.QuotientNode;
import parserModel.nodes.mathNodes.RandomNode;
import parserModel.nodes.mathNodes.RemainderNode;
import parserModel.nodes.mathNodes.SineNode;
import parserModel.nodes.mathNodes.SumNode;
import parserModel.nodes.mathNodes.TangentNode;
import parserModel.nodes.turtleNodes.BackwardNode;
import parserModel.nodes.turtleNodes.ClearNode;
import parserModel.nodes.turtleNodes.ForwardNode;
import parserModel.nodes.turtleNodes.HideNode;
import parserModel.nodes.turtleNodes.HomeNode;
import parserModel.nodes.turtleNodes.LeftTurnNode;
import parserModel.nodes.turtleNodes.PenDownNode;
import parserModel.nodes.turtleNodes.PenUpNode;
import parserModel.nodes.turtleNodes.RTurnNode;
import parserModel.nodes.turtleNodes.SetHeadingNode;
import parserModel.nodes.turtleNodes.SetXYNode;
import parserModel.nodes.turtleNodes.ShowNode;
import parserModel.nodes.turtleNodes.TowardsNode;
import parserModel.nodes.turtleQueries.PenDownPNode;
import parserModel.nodes.turtleQueries.ShowingPNode;
import parserModel.nodes.turtleQueries.XCorNode;
import parserModel.nodes.turtleQueries.YCorNode;

public class CommandFactory {

    /**
     * This is a huge case statement that turns 'identifier' strings into various instances of
     * ParserNode sub-classes
     * @param identifier    A particular string associated with a particular type of ParserNode.
     * @return              Returns subclass of ParserNode.
     */
    public ParserNode createCommand(String identifier, TurtleContext context){
        switch (identifier) {
            // TURTLE COMMANDS
            case "Forward":
                return new ForwardNode();
            case "Backward":
                return new BackwardNode();
            case "Left":
                return new LeftTurnNode();
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
            case "Tell":
                return new TellNode();
            case "Ask":
                return new AskNode();
        }
        return context.getData().getCommand(identifier);
    }
}
