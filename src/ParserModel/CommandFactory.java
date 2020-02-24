package ParserModel;

public class CommandFactory {

    public CommandFactory(){
    }

    public ParserNode createCommand(String identifier){
        switch(identifier){
            case "Forward":
                return new MoveAction();
            case "DoTimes":
                return new RepeatParserNode();
            case "For":
                return new ForParserNode();
        }
        return null;
    }
}
