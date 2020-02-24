package ParserModel;

import slogo.Main;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class TokenAnalyzer {
    private static final ResourceBundle SYNTAX = Main.SYNTAX;
    private static final ResourceBundle LANGUAGE = Main.RESOURCES;
    private static final String COMMENT = "Comment";
    private static final String CONSTANT = "Constant";
    private static final String VARIABLE = "Variable";
    private static final String COMMAND = "Command";
    private static final String LIST_START = "ListStart";
    private static final String LIST_END = "ListEnd";
    private static final String GROUP_START = "GroupStart";
    private static final String GROUP_END = "GroupEnd";

    private List<Entry<String, Pattern>> mySymbols;
    private List<Entry<String, Pattern>> myCommands;
    private Map<String, TokenType> myTokens;

    public enum TokenType {
        Comment,
        Constant,
        Variable,
        Command,
        ListStart,
        ListEnd,
        GroupStart,
        GroupEnd

    }

    public TokenAnalyzer(){
        addCommands();
        addPatterns();
        initializeTokenMap();
    }

    public TokenType typeOfToken(String token){
        return myTokens.get(checkArgument(token));
    }

    private boolean match(String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

    private String checkArgument(String text) {
        for (Entry<String, Pattern> e : mySymbols) {
            if (match(text, e.getValue())) {
                //System.out.println(e.getKey());
                return e.getKey();
            }
        }
        return "";
    }

    public String getKey(String text){
        final String ERROR = "NO MATCH";
        for (Entry<String, Pattern> e : myCommands) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        // FIXME: perhaps throw an exception instead
        return ERROR;

    }

    private void addCommands(){
        myCommands = new ArrayList<>();
        for (String key : Collections.list(LANGUAGE.getKeys())) {
            String regex = LANGUAGE.getString(key);
            myCommands.add(new SimpleEntry<>(key,
                    Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }


    /**
     * Adds the given resource file to this language's recognized types
     */
    private void addPatterns () {
        mySymbols = new ArrayList<>();
        for (String key : Collections.list(SYNTAX.getKeys())) {
            String regex = SYNTAX.getString(key);
            mySymbols.add(new SimpleEntry<>(key,
                    Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }

    private void initializeTokenMap(){
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
