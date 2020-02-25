package parserModel;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class TokenAnalyzer {
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
    private ResourceBundle SYNTAX;
    private ResourceBundle LANGUAGE;

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

    public TokenAnalyzer() {
        LANGUAGE = ResourceBundle.getBundle("parserModel.languages.English");
        SYNTAX = ResourceBundle.getBundle("parserModel.parsing.syntax");
        initializeCommands();
        initializePatterns();
        initializeTokenMap();
    }

    public TokenType typeOfToken(String token) {
        return myTokens.get(getTokenType(token));
    }

    private String getTokenType(String text) {
        for (Entry<String, Pattern> e : mySymbols) {
            if (e.getValue().matcher(text).matches()) {
                //System.out.println(e.getKey());
                return e.getKey();
            }
        }
        return "MESSED UP";
    }

    public String getTokenKey(String text) {
        for (Entry<String, Pattern> e : myCommands) {
            if (e.getValue().matcher(text).matches()) {
                return e.getKey();
            }
        }
        return "";
    }

    private List<Entry<String, Pattern>> createEntryList(ResourceBundle bundle) {
        List<Entry<String, Pattern>> newEntryList = new ArrayList();
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
