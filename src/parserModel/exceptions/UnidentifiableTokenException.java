package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class UnidentifiableTokenException extends ParsingException {
    private String myErrorToken;

    public UnidentifiableTokenException(String token){
        super();
        myErrorToken = token;
    }

    @Override
    public ParserNode toNode() {
        return new ErrorNode("ERROR: unidentifieable token '" + myErrorToken + "'");
    }
}
