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

        for(int i=0; i<2000; i++){
            test.setTurtleX(test.getTurtleX()+ 1 * Math.cos(Math.toRadians(0))); // 1
            test.setTurtleY(test.getTurtleY()+ 1 * Math.sin(Math.toRadians(0))); // 0
            test.draw();
        }
        for(int i=0; i<100; i++){
            test.setTurtleX(test.getTurtleX()+ 1 * Math.cos(Math.toRadians(90))); // 0
            test.setTurtleY(test.getTurtleY()+ 1 * Math.sin(Math.toRadians(90))); // 1
            test.draw();
        }
        for(int i=0; i<100; i++){
            test.setTurtleX(test.getTurtleX()+ 1 * Math.cos(Math.toRadians(180))); // -1
            test.setTurtleY(test.getTurtleY()+ 1 * Math.sin(Math.toRadians(180))); // 0
            test.draw();
        }
        for(int i=0; i<100; i++){
            test.setTurtleX(test.getTurtleX()+ 1 * Math.cos(Math.toRadians(270))); // 0
            test.setTurtleY(test.getTurtleY()+ 1 * Math.sin(Math.toRadians(270))); // -1
            test.draw();
        }
        test.setTurtlePen(false);
        for(int i=0; i<100; i++){
            test.setTurtleX(test.getTurtleX()+ 1 * Math.cos(Math.toRadians(45)));
            test.setTurtleY(test.getTurtleY()+ 1 * Math.sin(Math.toRadians(45)));
            test.draw();
        }
        test.setTurtlePen(true);
        for(int i=0; i<1000; i++){
            test.setTurtleX(test.getTurtleX()+ 1 * Math.cos(Math.toRadians(45)));
            test.setTurtleY(test.getTurtleY()+ 1 * Math.sin(Math.toRadians(45)));
            test.draw();
        }
    }
}
