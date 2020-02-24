package slogo;

import java.util.ResourceBundle;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main {
    private static final String RESOURCE_PACKAGE = "resources.languages.";
    private static final String LANGUAGE = "English";
    public static final ResourceBundle RESOURCES = ResourceBundle.getBundle(RESOURCE_PACKAGE + LANGUAGE);
    public static final ResourceBundle SYNTAX = ResourceBundle.getBundle("resources.regex.syntax");
    /**
     * Start of the program.
     */
    public static void main (String[] args) {
        System.out.println("Hello world");
    }
}
