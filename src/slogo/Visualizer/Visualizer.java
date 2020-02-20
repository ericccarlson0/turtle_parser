package slogo.Visualizer;
// myButton.disableProperty().bind(myMode.getProperty(BrowserProperty.NEXT))
import slogo.Visualizer.Turtle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Visualizer.java - a class for managing the frontend.
 * @author  Lorne Zhang
 * @version 1.0
 */
public class Visualizer {
    private final int SPLASH_SIZE_HEIGHT = 700;
    private final int SPLASH_SIZE_WIDTH = 1300;
    private final Color SPLASH_BACKGROUND = Color.WHITE;

    private final int ENVIRONMENT_SIZE_HEIGHT = 700;
    private final int ENVIRONMENT_SIZE_WIDTH = 1300;
    private final Color ENVIRONMENT_BACKGROUND = Color.WHITE;

    private final int FIELD_CENTER_X = 350;
    private final int FIELD_CENTER_Y = 350;
    private final int FIELD_HEIGHT = 650;
    private final int FIELD_WIDTH = 650;

    private Timeline animation;
    private Stage myStage;
    private Scene myScene;
    private Group myGroup;

    private ArrayList<Turtle> myTurtles;
    private int turtleIndex = 0;
    private final static String TURTLE_FILE = "images/ball.jpg";
    private final static Image TURTLE_IMAGE = new Image(TURTLE_FILE);

    private Text executedHistory;
    private Text inputHistory;
    private Text possibleCommands;
    private ScrollPane inputScrollPane;
    private ScrollPane executedScrollPane;
    private ScrollPane commandScrollPane;

    /**
     * Visualizer() - constructor for the visualizer.
     */
    public Visualizer(){
        start();
    }

    /**
     * getTurtleX() - getter for turtle's x coordinate.
     * @return int x for turtle's x coordinate.
     */
    public double getTurtleX(){
        return myTurtles.get(turtleIndex).getX();
    }

    /**
     * getTurtleY() - getter for turtle's y coordinate.
     * @return int y for turtle's y coordinate.
     */
    public double getTurtleY(){
        return myTurtles.get(turtleIndex).getY();
    }

    /**
     * setTurtleX() - setter for turtle's x coordinate.
     * @param xPos turtle's x coordinate.
     */
    public void setTurtleX(double xPos){
        myTurtles.get(turtleIndex).setX(xPos);
    }

    /**
     * setTurtleY() - setter for turtle's y coordinate.
     * @param yPos turtle's y coordinate.
     */
    public void setTurtleY(double yPos){
        myTurtles.get(turtleIndex).setY(yPos);
    }

    /**
     * getTurtleIndex() - getter for turtle index.
     * @return int turtleIndex which indexes which turtle is in control.
     */
    public int getTurtleIndex(){
        return turtleIndex;
    }

    /**
     * setTurtleIndex() - setter for turtle index.
     * @param index new turtle index.
     */
    public void setTurtleIndex(int index){
        turtleIndex = index;
    }

    private void start(){
        myStage = new Stage();
        myScene = setUpSplash();
        myStage.setScene(myScene);
        myStage.show();
        // start stage with splash
        // initiate stage
        // Scene = setUpSplash()
    }

    private void playAnimation(){
        myScene = setUpEnvironment();
        myStage.setScene(myScene);
        myStage.show();
        KeyFrame frame = new KeyFrame(Duration.millis(1), e -> {
            step();
        });
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    private void step(){
        // update turtle
        // position, pen, rotate, etc.
        System.out.println("Hi");
    }

    private Scene setUpSplash(){
        myGroup = new Group();
        // create button that has event handler that calls playAnimation
        Button playButon = makeButton("Press to Play", SPLASH_SIZE_WIDTH/4, SPLASH_SIZE_HEIGHT /4, myGroup);
        playButon.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                playAnimation();
            }
        });
        return new Scene(myGroup, SPLASH_SIZE_WIDTH, SPLASH_SIZE_HEIGHT, SPLASH_BACKGROUND);
    }

    private Scene setUpEnvironment() {
        myGroup = new Group();
        myTurtles = new ArrayList<Turtle>();
        inputHistory = new Text("user input history");
        executedHistory = new Text("executed command history");

        // create field
        Rectangle field = new Rectangle((ENVIRONMENT_SIZE_HEIGHT - FIELD_WIDTH)/2, (ENVIRONMENT_SIZE_HEIGHT - FIELD_WIDTH)/2, FIELD_WIDTH, FIELD_HEIGHT);
        field.setFill(Color.WHITE);
        myGroup.getChildren().add(field);

        // create turtle
        Turtle initialTurtle = new Turtle(TURTLE_IMAGE, FIELD_CENTER_X, FIELD_CENTER_Y);
        myTurtles.add(initialTurtle);
        myGroup.getChildren().add(initialTurtle);

        // create input scroll pane
        inputScrollPane = makeScrollPane(inputHistory, ENVIRONMENT_SIZE_HEIGHT, (ENVIRONMENT_SIZE_HEIGHT/7)/4, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, 250, 250);
        myGroup.getChildren().add(inputScrollPane);

        // create executed scroll pane
        executedScrollPane = makeScrollPane(executedHistory, ENVIRONMENT_SIZE_HEIGHT + 275, (ENVIRONMENT_SIZE_HEIGHT/7)/4, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, 250, 250);
        myGroup.getChildren().add(executedScrollPane);

        // create input text field


        return new Scene(myGroup, ENVIRONMENT_SIZE_WIDTH, ENVIRONMENT_SIZE_HEIGHT, ENVIRONMENT_BACKGROUND);
    }

    private Button makeButton(String text, int x, int y, Group group){
        Button myButton = new Button();
        myButton.setText(text);
        myButton.setLayoutX(x);
        myButton.setLayoutY(y);
        group.getChildren().add(myButton);
        return myButton;
    }

    private ScrollPane makeScrollPane(Text text, int x, int y, ScrollPane.ScrollBarPolicy hbar, ScrollPane.ScrollBarPolicy vbar, boolean fitHeight, boolean fitWidth, int width, int height) {
        ScrollPane scrollPane = new ScrollPane(text);
        scrollPane.setLayoutX(x);
        scrollPane.setLayoutY(y);
        scrollPane.setHbarPolicy(hbar);
        scrollPane.setVbarPolicy(vbar);
        scrollPane.setFitToHeight(fitHeight);
        scrollPane.setFitToWidth(fitWidth);
        scrollPane.setPrefSize(width, height);
        return scrollPane;
    }
}
