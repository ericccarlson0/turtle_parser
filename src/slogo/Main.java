import ParserModel.ParserNode;
import ParserModel.TreeParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Main {
    private static final String LANGUAGE_PACKAGE = "resources.languages.";
    private static final String LANGUAGE = "English";
    public static final ResourceBundle RESOURCES = ResourceBundle.getBundle(LANGUAGE_PACKAGE + LANGUAGE);
    public static final ResourceBundle SYNTAX = ResourceBundle.getBundle("resources.regex.syntax");
    public static void main(String[] args){
        String[] commands = new String[]{"DOTIMES","20","[", "Forward","40","Forward","20","]"};
        List<String> listCommands = Arrays.asList(commands);
        TreeParser parser = new TreeParser();
        ParserNode node = parser.parse(listCommands);
        node.execute();

    }
}
