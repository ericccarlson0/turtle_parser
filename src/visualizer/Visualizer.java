package visualizer;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Line;
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
import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * visualizer.java - a class for managing the frontend.
 * @author  Lorne Zhang
 * @version 1.0
 */
public class Visualizer {

    private static final String RESOURCE_FOLDER = "/stylesheets";
    private static final String STYLESHEET = "/default.css";
    private final int SPLASH_SIZE_HEIGHT = 700;
    private final int SPLASH_SIZE_WIDTH = 1300;
    private final Color SPLASH_BACKGROUND = Color.LIGHTGRAY;

    private final int ENVIRONMENT_SIZE_HEIGHT = 700;
    private final int ENVIRONMENT_SIZE_WIDTH = 1300;
    private final Color ENVIRONMENT_BACKGROUND = Color.LIGHTGRAY;

    private final int FIELD_CENTER_X = 350;
    private final int FIELD_CENTER_Y = 350;
    private final int FIELD_HEIGHT = 650;
    private final int FIELD_WIDTH = 650;
    private final int FIELD_RIGHT_EDGE = 675;
    private final int FIELD_LEFT_EDGE = 25;
    private final int OFFSET = 25;
    private final int SCROLLPANE_SIZE = 250;
    private Stage myStage;
    private Scene myScene;
    private Group myGroup;

    private ArrayList<visualizer.Turtle> myTurtles;
    private int turtleIndex = 0;
    private final static String TURTLE_FILE = "images/turtle.jpg";
    private final static Image TURTLE_IMAGE = new Image(TURTLE_FILE);

    private Text executedHistory;
    private Text inputHistory;
    private ScrollPane inputScrollPane;
    private ScrollPane executedScrollPane;

    private Text userInputText;
    private ScrollPane userInputScrollPane;
    private TextField userInputTextField;
    private Button inputButton;
    private ObservableList variableList;
    private ObservableList commandList;


    private String command = "";


    /**
     * visualizer() - constructor for the visualizer.
     */
    public Visualizer() {
        start();
    }

    /**
     * getTurtleX() - getter for turtle's x coordinate.
     *
     * @return int x for turtle's x coordinate.
     */
    public double getTurtleX() {
        return myTurtles.get(turtleIndex).getXCoordinate();
    }

    /**
     * getTurtleY() - getter for turtle's y coordinate.
     *
     * @return int y for turtle's y coordinate.
     */
    public double getTurtleY() {
        return myTurtles.get(turtleIndex).getYCoordinate();
    }

    /**
     * getTurtleX() - getter for turtle's x coordinate.
     *
     * @return int x for turtle's x coordinate.
     */
    public double getTurtleAngle() {
        return myTurtles.get(turtleIndex).getAngle();
    }

    /**
     * setTurtleX() - setter for turtle's x coordinate.
     *
     * @param xPos turtle's x coordinate.
     */
    public void setTurtleX(double xPos) {
        if (myTurtles.get(turtleIndex).getXCoordinate() > FIELD_RIGHT_EDGE) {
            myTurtles.get(turtleIndex).setXCoordinate(myTurtles.get(turtleIndex).getXCoordinate() - FIELD_HEIGHT);
            myTurtles.get(turtleIndex).setYCoordinate(myTurtles.get(turtleIndex).getYCoordinate() - OFFSET);

        } else if (myTurtles.get(turtleIndex).getXCoordinate() < FIELD_LEFT_EDGE) {
            myTurtles.get(turtleIndex).setXCoordinate(myTurtles.get(turtleIndex).getXCoordinate() + FIELD_HEIGHT);
            myTurtles.get(turtleIndex).setYCoordinate(myTurtles.get(turtleIndex).getYCoordinate() + OFFSET);

        } else {
            myTurtles.get(turtleIndex).setXCoordinate(xPos);
        }

    }

    public void setTurtleGameX(double xPos){
        myTurtles.get(turtleIndex).setXGameCoordinate(xPos);
    }

    public void setVariableList(ObservableList variableList){
        this.variableList = variableList;
    }

    public void setCommandList(ObservableList commandList){
        this.commandList = commandList;
    }

    public void setTurtleGameY(double yPos){
        myTurtles.get(turtleIndex).setYGameCoordinate(yPos);
    }

    /**
     * setTurtleY() - setter for turtle's y coordinate.
     *
     * @param yPos turtle's y coordinate.
     */
    public void setTurtleY(double yPos) {
        if (myTurtles.get(turtleIndex).getYCoordinate() > FIELD_RIGHT_EDGE) {
            myTurtles.get(turtleIndex).setYCoordinate(myTurtles.get(turtleIndex).getYCoordinate() - FIELD_HEIGHT);
            myTurtles.get(turtleIndex).setXCoordinate(myTurtles.get(turtleIndex).getXCoordinate() - OFFSET);
        } else if (myTurtles.get(turtleIndex).getYCoordinate() < FIELD_LEFT_EDGE) {
            myTurtles.get(turtleIndex).setYCoordinate(myTurtles.get(turtleIndex).getYCoordinate()+ FIELD_HEIGHT);
            myTurtles.get(turtleIndex).setXCoordinate(myTurtles.get(turtleIndex).getXCoordinate() + OFFSET);
        } else {
            myTurtles.get(turtleIndex).setYCoordinate(yPos);
        }
    }

    public void setTurtlePen(boolean x) {
        myTurtles.get(turtleIndex).setPen(x);
    }

    /**
     * setTurtleX() - setter for turtle's x coordinate.
     *
     * @param angle turtle's x coordinate.
     */
    public void setTurtleAngle(double angle) {
        myTurtles.get(turtleIndex).setAngle(angle);
    }

    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * getCommand() - getter for the string the user inputs.
     *
     * @return
     */
    public String getCommand() {
        return command;
    }

    /**
     * resetCommand() - resets the command to null.
     *
     * @return
     */
    public void resetCommand() {
        command = "";
    }

    public void clearScreen() {
        playAnimation();
    }

    public double getTurtlePen() {
        if (myTurtles.get(turtleIndex).getPen()) {
            return 1;
        }
        return 0;
    }

    public double getShowing() {
        if (myTurtles.get(turtleIndex).isVisible()) {
            return 1;
        }
        return 0;

    }

    public void show() {
        myTurtles.get(turtleIndex).setVisible(true);
    }

    public void hide() {
        myTurtles.get(turtleIndex).setVisible(false);
    }

    /**
     * addInputHistory() - add a string for the history of the input.
     *
     * @return
     */
    public void addInputHistory(String history) {
        inputHistory.setText(inputHistory.getText() + '\n' + history);
    }

    /**
     * addUserInput() - add a string to the actual user input. Acts like a terminal
     *
     * @return
     */
    public void addUserInput(String input) {
        userInputText.setText(userInputText.getText() + '\n' + input);
    }

    /**
     * addExecutedHistory() - add a string to the executed commands.
     *
     * @return
     */
    public void addExecutedHistory(String executed) {
        executedHistory.setText(executedHistory.getText() + '\n' + executed);
    }

    /**
     * getTurtleIndex() - getter for turtle index.
     *
     * @return int turtleIndex which indexes which turtle is in control.
     */
    public int getTurtleIndex() {
        return turtleIndex;
    }

    /**
     * setTurtleIndex() - setter for turtle index.
     *
     * @param index new turtle index.
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
        System.out.println("draw");
        if ((Math.abs(myTurtles.get(turtleIndex).getOldXCoordinate() - myTurtles.get(turtleIndex).getXCoordinate())) < FIELD_HEIGHT && (Math.abs(myTurtles.get(turtleIndex).getOldYCoordinate() - myTurtles.get(turtleIndex).getYCoordinate())) < FIELD_HEIGHT) {
            if (myTurtles.get(turtleIndex).getPen()) {
                Line line = new Line();
                line.setStartX(myTurtles.get(turtleIndex).getOldXCoordinate());
                line.setStartY(myTurtles.get(turtleIndex).getOldYCoordinate());
                line.setEndX(myTurtles.get(turtleIndex).getXCoordinate());
                line.setEndY(myTurtles.get(turtleIndex).getYCoordinate());
                myGroup.getChildren().add(line);
            }
        }
    }

    private void step() {

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

    private void setUpEnvironment() {
        myGroup = new Group();
        myTurtles = new ArrayList<visualizer.Turtle>();
        createField((ENVIRONMENT_SIZE_HEIGHT - FIELD_WIDTH) / 2,(ENVIRONMENT_SIZE_HEIGHT - FIELD_WIDTH) / 2, FIELD_WIDTH, FIELD_HEIGHT, Color.WHITE);
        createTurtle(TURTLE_IMAGE, FIELD_CENTER_X, FIELD_CENTER_Y, turtleIndex);


        inputHistory = new Text("user input history");
        executedHistory = new Text("executed command history");
        inputScrollPane = makeScrollPane(inputHistory, ENVIRONMENT_SIZE_HEIGHT + OFFSET*2, (ENVIRONMENT_SIZE_HEIGHT / 7) / 4, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        myGroup.getChildren().add(inputScrollPane);
        executedScrollPane = makeScrollPane(executedHistory, ENVIRONMENT_SIZE_HEIGHT + 275 + OFFSET*2, (ENVIRONMENT_SIZE_HEIGHT / 7) / 4, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        myGroup.getChildren().add(executedScrollPane);
        userInputText = new Text("Terminal");
        userInputTextField = new TextField("");
        inputButton = makeButton("Enter", ENVIRONMENT_SIZE_HEIGHT + 300, (ENVIRONMENT_SIZE_HEIGHT / 7) * 6 + 50, myGroup);
        inputButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                String x = userInputTextField.getText();
                inputHistory.setText(inputHistory.getText() + '\n' + x);
                userInputText.setText(userInputText.getText() + '\n' + "Command entered");
                userInputTextField.clear();
                setCommand(x);
            }
        });
        userInputTextField.setLayoutX(ENVIRONMENT_SIZE_HEIGHT + OFFSET*2);
        userInputTextField.setLayoutY((ENVIRONMENT_SIZE_HEIGHT / 7) * 6 + OFFSET*2);
        userInputScrollPane = makeScrollPane(userInputText, ENVIRONMENT_SIZE_HEIGHT + OFFSET*2, (ENVIRONMENT_SIZE_HEIGHT / 7) * 4, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, 525, 200);
        myGroup.getChildren().add(userInputScrollPane);
        myGroup.getChildren().add(userInputTextField);

        Button resetParser = makeButton("Reset", ENVIRONMENT_SIZE_HEIGHT + OFFSET*2, (ENVIRONMENT_SIZE_HEIGHT / 7) / 4 + (ENVIRONMENT_SIZE_HEIGHT / 7) * 3, myGroup);
        Button replayParser = makeButton("Replay", ENVIRONMENT_SIZE_HEIGHT + OFFSET*6, (ENVIRONMENT_SIZE_HEIGHT / 7) / 4 + (ENVIRONMENT_SIZE_HEIGHT / 7) * 3, myGroup);
        Button helpParser = makeButton("Help", ENVIRONMENT_SIZE_HEIGHT + OFFSET*10, (ENVIRONMENT_SIZE_HEIGHT / 7) / 4 + (ENVIRONMENT_SIZE_HEIGHT / 7) * 3, myGroup);
        Button variableButton = makeButton("Variables", ENVIRONMENT_SIZE_HEIGHT + OFFSET*14, (ENVIRONMENT_SIZE_HEIGHT / 7) / 4 + (ENVIRONMENT_SIZE_HEIGHT / 7) * 3, myGroup);
        Button commandButton = makeButton("Commands", ENVIRONMENT_SIZE_HEIGHT + OFFSET*18, (ENVIRONMENT_SIZE_HEIGHT / 7) / 4 + (ENVIRONMENT_SIZE_HEIGHT / 7) * 3, myGroup);
        commandButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Page popup = new Page(commandList);
            }
        });
        variableButton.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Page popup = new Page(variableList);
            }
        });
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
        ComboBox languageSelect = new ComboBox<String>();
        myScene = new Scene(myGroup, ENVIRONMENT_SIZE_WIDTH, ENVIRONMENT_SIZE_HEIGHT, ENVIRONMENT_BACKGROUND);
        String stylesheet = String.format("%s%s", RESOURCE_FOLDER, STYLESHEET);
        myScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
    }

    private void createTurtle(Image turtleImage, int x, int y, int turtleIndex) {
        Turtle initialTurtle = new visualizer.Turtle(turtleImage, x, y, turtleIndex);
        myTurtles.add(initialTurtle);
        myGroup.getChildren().add(initialTurtle);
    }

    private void createField(int x, int y, int width, int height, Color color) {
        Rectangle field = new Rectangle(x, y, width, height);
        field.setFill(color);
        myGroup.getChildren().add(field);
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