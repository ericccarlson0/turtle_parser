package slogo;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import visualizer.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class Main extends Application {
    private static final int SPLASH_WIDTH = 500;
    private static final int SPLASH_HEIGHT = 500;
    private static final String RESOURCE_FOLDER = "/stylesheets";
    private static final String STYLESHEET = "/default.css";
    public static void main (String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws IOException {
        initiate();
        //Controller test = new Controller();
    }

    private void initiate() {
        Stage splashStage = new Stage();
        Scene splashScene = createSplashScene();
        String stylesheet = String.format("%s%s", RESOURCE_FOLDER, STYLESHEET);
        splashScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
        splashStage.setScene(splashScene);
        splashStage.show();
    }

    private Scene createSplashScene() {
        Group splashGroup = new Group();
        BorderPane splashBorderPane = new BorderPane();

        Node splashButtons = createWorkSpaceButtons();
        splashBorderPane.setCenter(splashButtons);
        BorderPane.setAlignment(splashButtons, Pos.CENTER);

        Node splashWelcome = createWelcomeText();
        splashBorderPane.setTop(splashWelcome);
        BorderPane.setAlignment(splashWelcome, Pos.CENTER);

        Node splashInformation = createInformationText();
        splashBorderPane.setBottom(splashInformation);
        BorderPane.setAlignment(splashInformation, Pos.CENTER);

        splashGroup.getChildren().add(splashBorderPane);
        Scene splash = new Scene(splashGroup, SPLASH_WIDTH, SPLASH_HEIGHT);
        return splash;
    }

    private Node createInformationText() {
        VBox information = new VBox();
        Text title = new Text("Welcome To SLOGO by Mariusz, Eric, Cemal and Lorne");
        Text instructions = new Text("Press the Work Space button to start!");
        information.getChildren().add(title);
        information.getChildren().add(instructions);
        return information;
    }

    private Node createWorkSpaceButtons() {
        VBox buttons = new VBox();
        Button workSpace = new Button ("Work Space");
        workSpace.setOnAction(e -> createController());
        buttons.getChildren().add(workSpace);
        return buttons;
    }

    private void createController() {
        Controller newController = new Controller();
    }

    private Node createWelcomeText() {
        HBox welcome = new HBox();
        Text title = new Text("SLOGO");
        welcome.getChildren().add(title);
        return welcome;
    }

}
