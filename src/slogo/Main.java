package slogo;

import parserModel.ParserNode;
import parserModel.TreeParser;

import java.util.*;

public class Main {
    private static final String LANGUAGE_PACKAGE = "resources.languages.";
    private static final String LANGUAGE = "English";
    public static final String RESOURCE_FOLDER = "resources";
    public static final ResourceBundle RESOURCES = ResourceBundle.getBundle(LANGUAGE_PACKAGE + LANGUAGE);
    public static final ResourceBundle SYNTAX = ResourceBundle.getBundle("resources.parsing.syntax");
    public static void main(String[] args){
        Scanner kbReader = new Scanner(System.in);
        TreeParser parser = new TreeParser();
        while(true){
            ParserNode node = parser.parseString(kbReader.nextLine());
            node.execute();
        }


    }
}
