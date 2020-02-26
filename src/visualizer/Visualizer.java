package visualizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.File;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Line;
import javafx.animation.Timeline;
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
 * @author  Lorne Zhang
 * @version 1.0
 */
public class Visualizer {

    private static final String RESOURCE_FOLDER = "/stylesheets";
    private static final String STYLESHEET = "/default.css";
    private final int ENVIRONMENT_SIZE_HEIGHT = 800;
    private final int ENVIRONMENT_SIZE_WIDTH = 1200;
    private final Color ENVIRONMENT_BACKGROUND = Color.LIGHTGRAY;
    private final int FIELD_CENTER_X = 250;
    private final int FIELD_CENTER_Y = 250;
    private final int FIELD_HEIGHT = 500;
    private final int FIELD_WIDTH = 500;
    private final int FIELD_RIGHT_EDGE = 500; //675
    private final int FIELD_LEFT_EDGE = 0; //25
    private final int OFFSET = 25; //25
    private final int SCROLLPANE_SIZE = 250;
    private final int TEXTINPUT_SIZE = 150;
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
    private Text userInputText;
    private ScrollPane userInputScrollPane;
    private TextArea userInputTextField;
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

    public void setTurtleGameX(double xPos){
        myTurtles.get(turtleIndex).setXGameCoordinate(xPos);
    }

    public void setTurtleGameY(double yPos){
        myTurtles.get(turtleIndex).setYGameCoordinate(yPos);
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

    public void setVariableList(ObservableList variableList){
        this.variableList = variableList;
    }

    public void setCommandList(ObservableList commandList){
        this.commandList = commandList;
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
                parserField.getChildren().add(line);
            }
        }
    }

    private void setUpEnvironment() {
        myGroup = new Group();
        BorderPane layout = new BorderPane();

        myTurtles = new ArrayList<visualizer.Turtle>();
        parserField = new Group();
        parserField.getChildren().add(createField(0,0, FIELD_WIDTH, FIELD_HEIGHT, Color.WHITE));
        parserField.getChildren().add(createTurtle(TURTLE_IMAGE, FIELD_CENTER_X, FIELD_CENTER_Y, turtleIndex));
        HBox inputBox = new HBox();
        userInputText = new Text("Terminal");
        userInputTextField = new TextArea("");
        userInputScrollPane = makeScrollPane(userInputText, 0, 0, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, 525, TEXTINPUT_SIZE);
        inputBox.getChildren().add(userInputTextField);
        inputButton = makeButton("Enter", 0, 0, inputBox);
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
        inputBox.getChildren().add(userInputScrollPane);
        layout.setPrefSize(1200,800);
        layout.setBottom(inputBox);
        layout.setAlignment(inputBox,Pos.CENTER);
        Node environment = createEnvironmentButtons();
        layout.setTop(environment);
        layout.setAlignment(environment,Pos.CENTER);
        Node textEntry = createEnvironmentTextEntry();
        layout.setLeft(textEntry);
        layout.setAlignment(textEntry,Pos.CENTER);
        layout.setCenter(parserField);
        layout.setAlignment(parserField,Pos.CENTER);

        myGroup.getChildren().add(layout);
    }

    private Node createEnvironmentTextEntry() {
        VBox textEntry = new VBox();
        inputHistory = new Text("user input history");
        executedHistory = new Text("executed command history");
        inputScrollPane = makeScrollPane(inputHistory, 0, 0, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        executedScrollPane = makeScrollPane(executedHistory, 0, 0, ScrollPane.ScrollBarPolicy.NEVER, ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        textEntry.getChildren().add(inputScrollPane);
        textEntry.getChildren().add(executedScrollPane);
        return textEntry;
    }

    private Node createEnvironmentButtons() {
        HBox buttons = new HBox();
        Button resetButton = makeButton("Reset", 0, 0, buttons);
        Button replayParser = makeButton("Replay", 0, 0, buttons);
        Button helpButton = makeButton("Help", 0, 0, buttons);
        Button variableButton = makeButton("Variables", 0, 0, buttons);
        Button commandButton = makeButton("Commands", 0, 0, buttons);
        Button turtleImageFileButton = makeButton("New Turtle Image", 0, 0,  buttons);
        commandButton.setOnAction(event -> popUpButtonPressed(commandList));
        variableButton.setOnAction(event -> popUpButtonPressed(variableList));
        helpButton.setOnAction(event -> helpButtonPressed());
        resetButton.setOnAction(event -> playAnimation());

        //TODO CREATED COMBOBOX HERE
        final ComboBox languageChoiceComboBox = new ComboBox();
        languageChoiceComboBox.getItems().addAll(getFileNamesInFolder("src/parserModel/languages"));
        languageChoiceComboBox.setOnAction(event -> changeLanguage(languageChoiceComboBox.getValue().toString().replaceAll(".properties","")));
        myGroup.getChildren().add(languageChoiceComboBox);

        myScene = new Scene(myGroup, ENVIRONMENT_SIZE_WIDTH, ENVIRONMENT_SIZE_HEIGHT, ENVIRONMENT_BACKGROUND);
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

    private Node createTurtle(Image turtleImage, int x, int y, int turtleIndex) {
        Turtle initialTurtle = new visualizer.Turtle(turtleImage, x, y, turtleIndex);
        myTurtles.add(initialTurtle);
        return initialTurtle;
    }

    private Node createField(int x, int y, int width, int height, Color color) {
        Rectangle field = new Rectangle(x, y, width, height);
        field.setFill(color);
        return field;
    }

    private Button makeButton(String text, int x, int y, HBox buttons) {
        Button myButton = new Button();
        myButton.setText(text);
        myButton.setLayoutX(x);
        myButton.setLayoutY(y);
        buttons.getChildren().add(myButton);
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