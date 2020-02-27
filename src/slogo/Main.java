package slogo;

import visualizer.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class Main extends Application {

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
