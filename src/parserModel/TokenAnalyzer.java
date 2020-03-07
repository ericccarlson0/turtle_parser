package parserModel;

import parserModel.nodes.ParserNode;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * A class that analyzes a token inputted by the user and can fetch ParserNodes based on the token
 *
 * Based partially on code discussed in class by Robert Duvall
 *
 * @author Mariusz Derezinski-Choo
 */
public class TokenAnalyzer {
    private static final String DEFAULT_LANGUAGE = "ENGLISH";
    private static final String COMMAND_LANGUAGE_FOLDER = "commands.";

    private static final String COMMENT = "Comment";
    private static final String CONSTANT = "Constant";
    private static final String VARIABLE = "Variable";
    private static final String COMMAND = "Command";
    private static final String LIST_START = "ListStart";
    private static final String LIST_END = "ListEnd";
    private static final String GROUP_START = "GroupStart";
    private static final String GROUP_END = "GroupEnd";
    private static final String ERROR = "ERROR";

    private List<Entry<String, Pattern>> mySymbols;
    private List<Entry<String, Pattern>> myCommands;
    private Map<String, TokenType> myTokens;
    private ResourceBundle SYNTAX;
    private ResourceBundle LANGUAGE;

    /**
     * Construct a TokenAnalyzer object
     */
    public TokenAnalyzer() {
        LANGUAGE = ResourceBundle.getBundle(String.format("%s%s", COMMAND_LANGUAGE_FOLDER, DEFAULT_LANGUAGE));
        SYNTAX = ResourceBundle.getBundle("syntax");
        initializeCommands();
        initializePatterns();
        initializeTokenMap();
    }

    /**
     * Set the language that the tokens should be parsed at
     * @param language the language to be switched into
     */
    public void setLanguage(String language){
        LANGUAGE = ResourceBundle.getBundle(COMMAND_LANGUAGE_FOLDER + language);
        initializeCommands();
    }

    /**
     * Fetch teh node from the given token within the given context
     * @param token the token to be parsed
     * @param context the context that user-defined commands should be fetched from, should this command not be built-in
     * @return a ParserNode fetched from the token
     */
    public ParserNode fetchNode(String token, TurtleContext context) {
        return myTokens.getOrDefault(getTokenType(token),null)
            .renderNode(getTokenKey(token),token, context);
    }

    private String getTokenType(String text) {
        for (Entry<String, Pattern> e : mySymbols) {
            if (e.getValue().matcher(text).matches()) {
                //System.out.println(e.getKey());
                return e.getKey();
            }
        }
        return ERROR;
    }

    public String getTokenKey(String text) {
        for (Entry<String, Pattern> e : myCommands) {
            if (e.getValue().matcher(text).matches()) {
                return e.getKey();
            }
        }
        return text;
    }

    private List<Entry<String, Pattern>> createEntryList(ResourceBundle bundle) {
        List<Entry<String, Pattern>> newEntryList = new ArrayList<>();
        for (String key : Collections.list(bundle.getKeys())) {
            String regex = bundle.getString(key);
            newEntryList.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return newEntryList;
    }

    private void initializeCommands() {
        myCommands = createEntryList(LANGUAGE);
    }

    private void initializePatterns() {
        mySymbols = createEntryList(SYNTAX);
    }

    private void initializeTokenMap (){
        myTokens = new HashMap<>();
        myTokens.put(COMMENT, TokenType.Comment);
        myTokens.put(COMMAND, TokenType.Command);
        myTokens.put(CONSTANT, TokenType.Constant);
        myTokens.put(VARIABLE, TokenType.Variable);
        myTokens.put(LIST_START, TokenType.ListStart);
        myTokens.put(LIST_END, TokenType.ListEnd);
        myTokens.put(GROUP_START, TokenType.GroupStart);
        myTokens.put(GROUP_END, TokenType.GroupEnd);
    }
}
