package slogo;

import javafx.application.Application;
import javafx.stage.Stage;
import slogo.Visualizer.Visualizer;

import java.io.IOException;


public class Main extends Application {
    /**
     * Start of the program.
     */

    public static void main (String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException {
        System.out.println("Hello world");
        Visualizer test = new Visualizer();
    }
}
