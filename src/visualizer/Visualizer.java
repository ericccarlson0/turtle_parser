package visualizer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.File;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.ArrayList;

/**
 * visualizer.java - a class for managing the frontend.
 * @author  Lorne Zhang, Eric Carlson
 * @version 1.0
 */
public class Visualizer {
    private static final String RESOURCE_FOLDER = "/stylesheets";
    private static final String STYLESHEET = "/default.css";
    private static final int NODE_GAP = 8;
    private static final String BACKGROUND_COLOR = "BG Color:";
    private static final String PEN_COLOR = "Pen Color:";
    private static final String USER_INPUT_HISTORY = "INPUT HISTORY: \n";
    private static final String COMMAND_EXECUTION_HISTORY = "EXECUTION HISTORY: \n";
    private static final String TERMINAL = "TERMINAL: \n";

    private final int ENVIRONMENT_HEIGHT = 800;
    private final int ENVIRONMENT_WIDTH = 1200;
    private final Color ENVIRONMENT_BACKGROUND = Color.LIGHTGRAY;
    private final int FIELD_CENTER_X = 250;
    private final int FIELD_CENTER_Y = 250;
    private final int FIELD_HEIGHT = 500;
    private final int FIELD_WIDTH = 500;
    private final int FIELD_RIGHT_EDGE = 500; //675
    private final int FIELD_LEFT_EDGE = 0; //25
    private final int OFFSET = 25; //25
    private final int SCROLLPANE_SIZE = 250;
    private final int TEXT_INPUT_WIDTH = 400;
    private final int TEXT_INPUT_SIZE = 150;

    private final int SPLASH_SIZE_HEIGHT = 700;
    private final int SPLASH_SIZE_WIDTH = 1300;
    private final Color SPLASH_BACKGROUND = Color.LIGHTGRAY;

    private Stage myStage;
    private Scene myScene;
    private Group myGroup;
    private Group parserField;
    private ArrayList<visualizer.Turtle> myTurtles;
    private int turtleIndex = 0;

    private final static String TURTLE_FILE = "images/turtle.jpg";
    private final static Image TURTLE_IMAGE = new Image(TURTLE_FILE);
    private Text executedHistory;
    private Text inputHistory;
    private ScrollPane inputScrollPane;
    private ScrollPane executedScrollPane;

    private Text availableCommands;
    private Text availableVariables;
    private ScrollPane commandScrollPane;
    private ScrollPane variableScrollPane;

    private Text userInputText;
    private ScrollPane userInputScrollPane;
    private TextArea userInputTextArea;
    private Button inputButton;
    private ObservableList variableList;
    private ObservableList commandList;
    private ColorChoice envColorChoice;
    private ColorChoice penColorChoice;
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

    public void setTurtleGameX(double xPos){
        myTurtles.get(turtleIndex).setXGameCoordinate(xPos);
    }

    public void setTurtleGameY(double yPos){
        myTurtles.get(turtleIndex).setYGameCoordinate(yPos);
    }

    public double getTurtleGameX(){
        return myTurtles.get(turtleIndex).getXGameCoordinate();
    }

    public double getTurtleGameY(){
        return myTurtles.get(turtleIndex).getYGameCoordinate();
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

    public void setVariableList(ObservableList variableList){
        this.variableList = variableList;
    }

    public void setCommandList(ObservableList commandList){
        this.commandList = commandList;

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
                parserField.getChildren().add(line);
            }
        }
    }

    private void setUpEnvironment() {
        myGroup = new Group();
        BorderPane layout = new BorderPane();
        Insets insets = new Insets(NODE_GAP/2);

        myTurtles = new ArrayList<>();
        parserField = new Group();
        Node field = createField(0,0, FIELD_WIDTH, FIELD_HEIGHT, Color.WHITE);
        Node turtle = createTurtle(TURTLE_IMAGE, FIELD_CENTER_X, FIELD_CENTER_Y, turtleIndex);
        parserField.getChildren().addAll(field, turtle);

        HBox inputBox = setUpInputBox();

        layout.setPrefSize(ENVIRONMENT_WIDTH - NODE_GAP, ENVIRONMENT_HEIGHT - NODE_GAP);
        layout.setBottom(inputBox);
        layout.setAlignment(inputBox, Pos.CENTER);
        BorderPane.setMargin(inputBox, insets);

        Node envButtons = createEnvironmentButtons();
        layout.setTop(envButtons);
        layout.setAlignment(envButtons, Pos.CENTER);
        BorderPane.setMargin(envButtons, insets);

        Node textArea = createEnvTextArea();
        layout.setLeft(textArea);
        layout.setAlignment(textArea, Pos.CENTER);
        BorderPane.setMargin(textArea, insets);

        Node envLists = createEnvLists();
        layout.setRight(envLists);
        layout.setAlignment(envLists, Pos.CENTER);
        BorderPane.setMargin(envLists, insets);

        layout.setCenter(parserField);
        layout.setAlignment(parserField, Pos.CENTER);
        BorderPane.setMargin(parserField, insets);

        myGroup.getChildren().add(layout);
    }

    private Node createTurtle(Image turtleImage, int x, int y, int turtleIndex) {
        Turtle initialTurtle = new visualizer.Turtle(turtleImage, x, y, turtleIndex);
        myTurtles.add(initialTurtle);
        return initialTurtle;
    }

    private HBox setUpInputBox() {
        HBox inputBox = new HBox(NODE_GAP);
        userInputText = new Text(TERMINAL);
        userInputTextArea = new TextArea("");
        userInputScrollPane = createScrollPane(userInputText, NODE_GAP, NODE_GAP, ScrollPane.ScrollBarPolicy.NEVER,
            ScrollPane.ScrollBarPolicy.ALWAYS, true, true, TEXT_INPUT_WIDTH, TEXT_INPUT_SIZE);

        inputButton = createButton("ENTER", 0, 0, inputBox);
        inputButton.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                String newText = userInputTextArea.getText();
                inputHistory.setText(inputHistory.getText() + '\n' + newText);
                userInputText.setText(userInputText.getText() + '\n' + "(command entered)");
                userInputTextArea.clear();
                setCommand(newText);
            }
        });
        inputBox.getChildren().addAll(userInputTextArea, userInputScrollPane);
        return inputBox;
    }

    private Node createEnvLists() {
        VBox envLists = new VBox(NODE_GAP);
        Page commands = new Page(commandList);
        Page variables = new Page(variableList);
        envColorChoice = new ColorChoice(BACKGROUND_COLOR, 255, 255, 255);
        penColorChoice = new ColorChoice(PEN_COLOR, 0, 0, 0);
        envLists.getChildren().addAll(commands.getScrollPane(), variables.getScrollPane(),
            envColorChoice.getVisual(), penColorChoice.getVisual());
        return envLists;
    }

    private Node createEnvTextArea() {
        VBox inputArea = new VBox(NODE_GAP);
        inputHistory = new Text(USER_INPUT_HISTORY);
        executedHistory = new Text(COMMAND_EXECUTION_HISTORY);
        inputScrollPane = createScrollPane(inputHistory, 0, 0, ScrollPane.ScrollBarPolicy.NEVER,
            ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        executedScrollPane = createScrollPane(executedHistory, 0, 0, ScrollPane.ScrollBarPolicy.NEVER,
            ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        inputArea.getChildren().addAll(inputScrollPane, executedScrollPane);
        return inputArea;
    }

    private Node createEnvironmentButtons() {
        HBox buttons = new HBox(NODE_GAP);

        Button resetButton = createButton("RESET", 0, 0, buttons);
        resetButton.setOnAction(event -> playAnimation());

        Button replayParser = createButton("REPLAY", 0, 0, buttons);

        Button helpButton = createButton("HELP", 0, 0, buttons);
        helpButton.setOnAction(event -> helpButtonPressed());

        //Button variableButton = makeButton("VARIABLES", 0, 0, buttons);
        //Button commandButton = makeButton("COMMANDS", 0, 0, buttons);

        Button turtleImageFileButton = createButton("NEW TURTLE IMAGE", 0, 0,  buttons);

        //commandButton.setOnAction(event -> popUpButtonPressed(commandList));
        //variableButton.setOnAction(event -> popUpButtonPressed(variableList));

        ComboBox languageBox = createLanguageBox();
        buttons.getChildren().add(languageBox);

        myScene = new Scene(myGroup, ENVIRONMENT_WIDTH, ENVIRONMENT_HEIGHT, ENVIRONMENT_BACKGROUND);
        String stylesheet = String.format("%s%s", RESOURCE_FOLDER, STYLESHEET);
        myScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
        turtleImageFileButton.setOnAction(event -> turtleImageButtonPressed());
        return buttons;
    }

    private void helpButtonPressed() {
        HelpPage popup = new HelpPage();
    }

    private void popUpButtonPressed(ObservableList list) {
        Page popup = new Page(list);
    }

    private Node createField(int x, int y, int width, int height, Color color) {
        Rectangle field = new Rectangle(x, y, width, height);
        field.setFill(color);
        return field;
    }

    private ComboBox createLanguageBox() {
        ComboBox lb = new ComboBox();
        lb.getItems().addAll(getFileNamesInFolder("src/parserModel/languages"));
        lb.setOnAction(event -> changeLanguage(lb.getValue().toString().replaceAll(".properties","")));
        lb.setPromptText("Select Language");
        return lb;
    }

    private Button createButton(String text, int x, int y, HBox buttons) {
        Button myButton = new Button();
        myButton.setText(text);
        myButton.setLayoutX(x);
        myButton.setLayoutY(y);
        buttons.getChildren().add(myButton);
        return myButton;
    }

    private ScrollPane createScrollPane(Node text, int x, int y, ScrollPane.ScrollBarPolicy hbar,
        ScrollPane.ScrollBarPolicy vbar, boolean fitHeight, boolean fitWidth, int width, int height) {
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

    private void setTurtleImage(File imageFile){
        Image newTurtleImage = new Image(imageFile.toURI().toString());
        Turtle currentTurtle = myTurtles.get(turtleIndex);
        double xCoordinate = currentTurtle.getXCoordinate();
        double yCoordinate = currentTurtle.getYCoordinate();
        myGroup.getChildren().remove(currentTurtle);
        myTurtles.remove(turtleIndex);
        Turtle newTurtle = new Turtle(newTurtleImage,(int) xCoordinate,(int) yCoordinate,turtleIndex);
        myTurtles.add(turtleIndex,newTurtle);
        myGroup.getChildren().add(newTurtle);
    }

    private void turtleImageButtonPressed() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(myStage);
        if (selectedFile == null) {
            System.out.println("You must select a file");
            return;
        }
        setTurtleImage(selectedFile);
    }

    private List<String> getFileNamesInFolder(String folderPath){
        List<String> filesNames = new ArrayList<String>();
        File[] files = new File(folderPath).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                filesNames.add(file.getName());
            }
        }
        return filesNames;
    }

    private void changeLanguage(String languageChoice){
        File languageChoiceFile = new File("resources/languages/"+"LanguageChoice.properties");
        FileWriter writer;
        try {
            writer = new FileWriter(languageChoiceFile);
            writer.write("Language = "+languageChoice);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}