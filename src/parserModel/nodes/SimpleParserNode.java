package parserModel.nodes;

public abstract class SimpleParserNode implements ParserNode {
    protected String myEnteredText;
    public SimpleParserNode(String text){
        myEnteredText = text;
    }

    @Override
    public String toString(){
        return myEnteredText;
    }
}
