package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An Exception that represents when a token is unidentifiable
 * i.e it does not match any of the regexes
 *
 * @author Mariusz Derezinski-Choo
 */
public class UnidentifiableTokenException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "UnidentifiableToken";

    private String myErrorToken;

    /**
     * Construct an Unidentifiable Token
     * @param token the token that was unable to be identified
     */
    public UnidentifiableTokenException(String token){
        super();
        myErrorToken = token;
    }

    @Override
    public ParserNode renderNode(){
        return new ErrorNode(String.format(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY),myErrorToken));
    }
}
