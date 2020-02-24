package ParserModel;

import ParserModel.TurtleCommands.*;

public class CommandFactory {

    public CommandFactory(){
    }

    public ParserNode createCommand(String identifier){
        switch(identifier){
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




            case "DoTimes":
                return new RepeatParserNode();
            case "For":
                return new ForParserNode();
        }
        return null;
    }
}
