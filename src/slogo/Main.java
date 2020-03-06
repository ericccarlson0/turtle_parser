package slogo;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import visualizer.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

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
        GridPane topLevelGrid = new GridPane();

        Node welcome = createWelcomeText();
        topLevelGrid.add(welcome, 0, 0);
        Node information = createInformationText();
        topLevelGrid.add(information, 0, 1);

        Node workspaceButtons = createWorkspaceButtons();
        topLevelGrid.add(workspaceButtons, 0, 2);

        splashGroup.getChildren().add(topLevelGrid);
        Scene scene = new Scene(splashGroup, SPLASH_WIDTH, SPLASH_HEIGHT);
        return scene;
    }

    private Node createInformationText() {
        VBox information = new VBox();
        Text title = new Text(String.format("%s%n%s", "Welcome To SLOGO", "by MARIUSZ, ERIC, CEMAL and LORNE"));
        Text instructions = new Text("Press the button to create a new workspace: ");
        information.getChildren().addAll(title, instructions);
        return information;
    }

    private Node createWorkspaceButtons() {
        VBox buttons = new VBox();
        Button workspace = new Button ("WORKSPACE");
        workspace.setOnAction(e -> createWorkspace());
        buttons.getChildren().add(workspace);
        return buttons;
    }

    private void createWorkspace() {
        Controller newWorkspace = new Controller();
    }

    private Node createWelcomeText() {
        HBox welcome = new HBox();
        Text title = new Text("SLOGO");
        title.setId("title-text");
        welcome.getChildren().add(title);
        return welcome;
    }
}
