package testing;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

// *** TODO:
// update according to language: commands, history, buttons, etc.
// turtle / pen status
// undo commands (previous state?)
// animation and speed (*** DONE)
// separate 'workspaces' (essentially what Visualizer is now) *** SPLASH SCREEN
// clickable text to:
//  (1) execute commands from history
//  (2) execute user-defined commands, with parameters
//  (3) edit active turtles
//  (4) edit PEN properties
//  (5) manually move turtles (FD/BK/RT/LT)

public class TestingMain extends Application {
  public static void main (String[] args) {
    launch(args);
  }
  public void start(Stage stage) throws IOException {
    PopupWindowTester test = new PopupWindowTester();
  }
}
