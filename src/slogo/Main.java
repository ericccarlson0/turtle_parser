package slogo;
        import visualizer.Controller;
        import javafx.application.Application;
        import javafx.stage.Stage;


        import java.io.IOException;
        import java.util.*;

public class Main extends Application {

    private static final String LANGUAGE_PACKAGE = "languages.";
    private static final String LANGUAGE = "English";
    //public static final String RESOURCE_FOLDER = "resources.";
    //public static final ResourceBundle SYNTAX = ResourceBundle.getBundle("resources.parsing.syntax");
    //public static final ResourceBundle RESOURCES = ResourceBundle.getBundle("resources.languages.English");


     public static void main (String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException {
        Controller test = new Controller();

    }
}

/**
 * Scanner kbReader = new Scanner(System.in);
 *         TreeParser parser = new TreeParser(new ArrayList<>());
 *         while(true){
 *             CommandParserNode node = parser.parseString(kbReader.nextLine());
 *             node.execute();
 *         }
 */