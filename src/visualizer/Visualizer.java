package visualizer;
import javafx.scene.shape.Line;
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
import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * visualizer.java - a class for managing the frontend.
 * @author  Lorne Zhang, Eric Carlson
 * @version 1.0
 */
public class Visualizer {

    private final int SPLASH_SIZE_HEIGHT = 700;
    private final int SPLASH_SIZE_WIDTH = 1300;
    private final Color SPLASH_BACKGROUND = Color.LIGHTGRAY;

    private final int ENVIRONMENT_HEIGHT = 700;
    private final int ENVIRONMENT_WIDTH = 1300;
    private final Color ENVIRONMENT_BACKGROUND = Color.LIGHTGRAY;

    private final int FIELD_CENTER_X = 350;
    private final int FIELD_CENTER_Y = 350;
    private final int FIELD_HEIGHT = 650;
    private final int FIELD_WIDTH = 650;
    private final int OFF_SCREEN_BUFFER = 25;

    private Stage myStage;
    private Scene myScene;
    private Group myGroup;

    private ArrayList<visualizer.Turtle> myTurtles;
    private int turtleIndex = 0;
    private static final String TURTLE_FILE = "images/turtle.jpg";
    private static final Image TURTLE_IMAGE = new Image(TURTLE_FILE);

    private static final String RESOURCE_FOLDER = "/stylesheets";
    private static final String STYLESHEET = "/default.css";
    private static final String COMMAND_HISTORY = "EXECUTED COMMAND HISTORY: " ;
    private static final String INPUT_HISTORY = "USER INPUT HISTORY: ";

    private Text executedHistory;
    private Text inputHistory;
    private Text availableCommands;
    private Text availableVariables;
    private ScrollPane inputScrollPane;
    private ScrollPane executedScrollPane;
    private ScrollPane commandScrollPane;
    private ScrollPane variableScrollPane;

    private Text userInputText;
    private ScrollPane userInputScrollPane;
    private TextField userInputTextField;
    private Button inputButton;

    private int step = 0;
    private String command = "";


    /**
     * visualizer() - constructor for the visualizer.
     */
    public Visualizer() {
        start();
    }

    /**
     * getTurtleX() - getter for turtle's x coordinate.
     * @return int x for turtle's x coordinate.
     */
    public double getTurtleX() {
        return myTurtles.get(turtleIndex).getXCoordinate();
    }

    /**
     * getTurtleY() - getter for turtle's y coordinate.
     * @return int y for turtle's y coordinate.
     */
    public double getTurtleY() {
        return myTurtles.get(turtleIndex).getYCoordinate();
    }

    /**
     * getTurtleAngle() - getter for turtle's heading (angle).
     * @return int x for turtle's x coordinate.
     */
    public double getTurtleAngle() {
        return myTurtles.get(turtleIndex).getAngle();
    }

    /**
     * setTurtleX() - setter for turtle's x coordinate.
     * @param xPos turtle's x coordinate.
     */
    public void setTurtleX(double xPos) {
        Turtle currTurtle = myTurtles.get(turtleIndex);
        if (currTurtle.getXCoordinate() > 675) {
            currTurtle.setXCoordinate(currTurtle.getXCoordinate() - 650);
            currTurtle.setYCoordinate(currTurtle.getYCoordinate() - 25);

        } else if (currTurtle.getXCoordinate() < 25) {
            currTurtle.setXCoordinate(currTurtle.getXCoordinate() + 650);
            currTurtle.setYCoordinate(currTurtle.getYCoordinate() + 25);

        } else {
            currTurtle.setXCoordinate(xPos);
        }

    }

    /**
     * setTurtleY() - setter for turtle's y coordinate.
     * @param yPos turtle's y coordinate.
     */
    public void setTurtleY(double yPos) {
        Turtle currTurtle = myTurtles.get(turtleIndex);
        if (currTurtle.getYCoordinate() > 675) {
            currTurtle.setYCoordinate(currTurtle.getYCoordinate() - 650);
            currTurtle.setXCoordinate(currTurtle.getXCoordinate() - 25);
        } else if (currTurtle.getYCoordinate() < 25) {
            currTurtle.setYCoordinate(currTurtle.getYCoordinate()+ 650);
            currTurtle.setXCoordinate(currTurtle.getXCoordinate() + 25);
        } else {
            currTurtle.setYCoordinate(yPos);
        }
    }

    public void setTurtleGameX(double xPos){
        myTurtles.get(turtleIndex).setXGameCoordinate(xPos);
    }

    public void setTurtleGameY(double yPos){
        myTurtles.get(turtleIndex).setYGameCoordinate(yPos);
    }

    public void setTurtlePen(boolean x) {
        myTurtles.get(turtleIndex).setPen(x);
    }

    /**
     * setTurtleAngle() - setter for turtle's heading (angle).
     * @param angle turtle's x coordinate.
     */
    public void setTurtleAngle(double angle) {
        myTurtles.get(turtleIndex).setAngle(angle);
    }

    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * getCommand() - getter for the String the user inputs.
     * @return
     */
    public String getCommand() {
        return command;
    }

    /**
     * resetCommand() - resets the command to null.
     * @return
     */
    public void resetCommand() {
        command = "";
    }

    public void clearScreen() {
        playAnimation();
    }

    public double getTurtlePen() {
        if (myTurtles.get(turtleIndex).getPen()) { return 1; }
        return 0;
    }

    public double getShowing() {
        if (myTurtles.get(turtleIndex).isVisible()) { return 1; }
        return 0;

    }

    public void show() {
        myTurtles.get(turtleIndex).setVisible(true);
    }

    public void hide() {
        myTurtles.get(turtleIndex).setVisible(false);
    }

    /**
     * addInputHistory() - add a String for the history of the input.
     * @return
     */
    public void addInputHistory(String history) {
        inputHistory.setText(inputHistory.getText() + '\n' + history);
    }

    /**
     * addUserInput() - add a String to the actual user inputl; acts like a terminal.
     * @return
     */
    public void addUserInput(String input) {
        userInputText.setText(userInputText.getText() + '\n' + input);
    }

    /**
     * addExecutedHistory() - add a String to the executed commands.
     * @return
     */
    public void addExecutedHistory(String executed) {
        executedHistory.setText(executedHistory.getText() + '\n' + executed);
    }

    /**
     * getTurtleIndex() - getter for turtle index.
     * @return int turtleIndex, the index of the turtle that is in control at the moment.
     */
    public int getTurtleIndex() {
        return turtleIndex;
    }

    /**
     * setTurtleIndex() - setter for turtle index.
     * @param index the index of the new Turtle in control.
     */
    public void setTurtleIndex(int index) {
        turtleIndex = index;
    }

    private void start() {
        myStage = new Stage();
        playAnimation();

    }

    private void playAnimation() {
        setUpEnvironment();
        myStage.setScene(myScene);
        myStage.show();
    }

    public void draw() {
        System.out.println("DRAW");
        Turtle currTurtle = myTurtles.get(turtleIndex);
        if ((Math.abs(currTurtle.getOldXCoordinate() - currTurtle.getXCoordinate())) < 650
            && (Math.abs(currTurtle.getOldYCoordinate() - currTurtle.getYCoordinate())) < 650) {
            if (currTurtle.getPen()) {
                Line line = new Line();
                line.setStartX(currTurtle.getOldXCoordinate());
                line.setStartY(currTurtle.getOldYCoordinate());
                line.setEndX(currTurtle.getXCoordinate());
                line.setEndY(currTurtle.getYCoordinate());
                myGroup.getChildren().add(line);
            }
        }
    }

    private void setUpEnvironment() {
        initializeComponents();

        Rectangle turtleEnvironment = createTurtleEnvironment();
        Turtle initialTurtle = createInitialTurtle();
        inputScrollPane = makeScrollPane(inputHistory, ENVIRONMENT_HEIGHT + 50, ENVIRONMENT_HEIGHT/28,
            ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS,
            true, true, 250, 250);
        executedScrollPane = makeScrollPane(executedHistory, ENVIRONMENT_HEIGHT + 275 + 50, ENVIRONMENT_HEIGHT/28,
            ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS,
            true, true, 250, 250);
        myGroup.getChildren().addAll(turtleEnvironment, initialTurtle, inputScrollPane, executedScrollPane);

        setUpUserInput();
        myGroup.getChildren().addAll(userInputScrollPane, userInputTextField);

        setUpButtons();

        myScene = new Scene(myGroup, ENVIRONMENT_WIDTH, ENVIRONMENT_HEIGHT, ENVIRONMENT_BACKGROUND);
        String stylesheet = String.format("%s%s", RESOURCE_FOLDER, STYLESHEET);
        myScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
    }

    private void initializeComponents() {
        myGroup = new Group();
        myTurtles = new ArrayList<>();
        inputHistory = new Text(INPUT_HISTORY);
        executedHistory = new Text(COMMAND_HISTORY);
    }

    private Rectangle createTurtleEnvironment() {
        Rectangle env = new Rectangle((ENVIRONMENT_HEIGHT - FIELD_WIDTH)/2,
            (ENVIRONMENT_HEIGHT - FIELD_WIDTH)/2, FIELD_WIDTH, FIELD_HEIGHT);
        env.setFill(Color.WHITE);
        return env;
    }

    private Turtle createInitialTurtle() {
        Turtle turt = new Turtle(TURTLE_IMAGE, FIELD_CENTER_X, FIELD_CENTER_Y, turtleIndex);
        myTurtles.add(turt);
        return turt;
    }

    private void setUpUserInput() {
        userInputText = new Text("TERMINAL: ");
        userInputTextField = new TextField("");
        inputButton = makeButton("ENTER ", ENVIRONMENT_HEIGHT + 300, (ENVIRONMENT_HEIGHT / 7) * 6 + 50, myGroup);
        inputButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                String newText = userInputTextField.getText();
                inputHistory.setText(inputHistory.getText() + '\n' + newText);
                userInputText.setText(userInputText.getText() + '\n' + "(command entered)");
                userInputTextField.clear();
                setCommand(newText);
            }
        });
        userInputTextField.setLayoutX(ENVIRONMENT_HEIGHT + 50);
        userInputTextField.setLayoutY((ENVIRONMENT_HEIGHT / 7) * 6 + 50);

        userInputScrollPane = makeScrollPane(userInputText, ENVIRONMENT_HEIGHT + 50, ENVIRONMENT_HEIGHT/28,
            ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS,
            true, true, 525, 200);
    }

    private void setUpButtons() {
        Button resetParser = makeButton("RESET", ENVIRONMENT_HEIGHT + 50, (ENVIRONMENT_HEIGHT / 7) / 4 + (ENVIRONMENT_HEIGHT / 7) * 3, myGroup);
        Button replayParser = makeButton("REPLAY", ENVIRONMENT_HEIGHT + 150, (ENVIRONMENT_HEIGHT / 7) / 4 + (ENVIRONMENT_HEIGHT / 7) * 3, myGroup);
        Button helpParser = makeButton("HELP", ENVIRONMENT_HEIGHT + 250, (ENVIRONMENT_HEIGHT / 7) / 4 + (ENVIRONMENT_HEIGHT / 7) * 3, myGroup);
        helpParser.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                HelpPage popup = new HelpPage();
            }
        });
        resetParser.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                playAnimation();
            }
        });
    }

    private Scene setUpSplash() {
        myGroup = new Group();
        // create button that has event handler that calls playAnimation
        Button playButon = makeButton("Press to Play", SPLASH_SIZE_WIDTH / 4, SPLASH_SIZE_HEIGHT / 4, myGroup);
        playButon.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                playAnimation();
            }
        });
        return new Scene(myGroup, SPLASH_SIZE_WIDTH, SPLASH_SIZE_HEIGHT, SPLASH_BACKGROUND);
    }

    private Button makeButton(String text, int x, int y, Group group) {
        Button myButton = new Button();
        myButton.setText(text);
        myButton.setLayoutX(x);
        myButton.setLayoutY(y);
        group.getChildren().add(myButton);
        return myButton;
    }

    private ScrollPane makeScrollPane(javafx.scene.Node text, int x, int y, ScrollPane.ScrollBarPolicy hbar, ScrollPane.ScrollBarPolicy vbar, boolean fitHeight, boolean fitWidth, int width, int height) {
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