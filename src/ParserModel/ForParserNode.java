package ParserModel;

import javax.swing.text.html.parser.Parser;

public class ForParserNode extends ParserNode {
    private ParserNode myForNode;
    private ParserNode bodyNode;

    @Override
    public void addNode(ParserNode node) {
        if(myForNode == null){
            myForNode = node;
        } else if(bodyNode == null){
            bodyNode = node;
        }
    }

    @Override
    public double execute() {
        //TODO
        return 0;
    }

    @Override
    public boolean isComplete() {
        return bodyNode != null;
    }

}
