package visualizer;

import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * visualizer.java - a class for managing the frontend.
 * @author  Lorne Zhang, Eric Carlson
 * @version 1.0
 */
public class Visualizer {
    private static final String RESOURCE_FOLDER = "/stylesheets";
    private static final String STYLESHEET = "/default.css";
    private static final int NODE_GAP = 8;
    private static final String BACKGROUND_COLOR = "BG:";
    private static final String PEN_COLOR = "PEN:";
    private static final String USER_INPUT_HISTORY = "INPUT HISTORY: \n";
    private static final String COMMAND_EXECUTION_HISTORY = "EXECUTION HISTORY: \n";
    private static final String TERMINAL = "TERMINAL: \n";
    private static final Insets MARGINS = new Insets(10,10,10,10);
    private static final double FIELD_SIZE = 500;
    private static final int SCROLLPANE_SIZE = 250;
    private static final int TEXT_INPUT_WIDTH = 400;
    private static final int TEXT_INPUT_SIZE = 150;
    private static final String TURTLE_FILE = "images/turtle.jpg";
    private static final Image TURTLE_IMAGE = new Image(TURTLE_FILE);
    public static final int MAX_RGB = 255;
    private static final double TURTLE_SPEED = 10;

    private boolean history = false;
    private Stage myStage;
    private Scene myScene;

    private Pane myParserPane;
    private Group parserField;
    private ArrayList<Turtle> myTurtles;
    private int turtleIndex = 0;
    private Text executedHistory;
    private Text inputHistory;
    private Text userInputText;
    private TextArea userInputTextArea;
    private ColorChoice envColorChoice;
    private ColorChoice penColorChoice;
    private String command = "";
    private Page variablesPage;
    private Page commandsPage;
    private ComboBox<String> languageBox;
    private List<Transition> myTransitionQueue;

    /**
     * visualizer() - constructor for the visualizer.
     */
    public Visualizer() {
        myTransitionQueue = new ArrayList<>();
        start();
    }

    public void setPosition(double startX, double startY, double endX, double endY){
        Turtle currentTurlte = myTurtles.get(turtleIndex);
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.layoutXProperty().bind(Bindings.divide(myParserPane.widthProperty(), 2.0));
        line.layoutYProperty().bind(Bindings.divide(myParserPane.heightProperty(), 2.0));
            myParserPane.getChildren().add(line);
            PathTransition pathTransition = new PathTransition();

            //Setting the duration of the path transition
            double time = Math.sqrt(Math.pow(startY - endY, 2) + Math.pow(startX - endX, 2)) / TURTLE_SPEED;

            pathTransition.setDuration(Duration.millis(time));
            //Setting the node for the transition
            pathTransition.setNode(currentTurlte);
            pathTransition.setPath(line);
            pathTransition.setCycleCount(1);
            myTransitionQueue.add(pathTransition);
            pathTransition.setOnFinished(event -> {
                myTransitionQueue.remove(0);
                if(! myTransitionQueue.isEmpty()){
                    myTransitionQueue.get(0).play();
                }
            });
            if(myTransitionQueue.size() == 1){
                pathTransition.play();
            }

    }

    /**
     * setTurtlePen() - setter for the turtle's pen status.
     * @param pen boolean turtle's pen status.
     */
    public void setTurtlePen(boolean pen) {
        myTurtles.get(turtleIndex).setPen(pen);
    }

    /**
     * setTurtleAngle() - setter for turtle's heading (angle).
     * @param angle turtle's x coordinate.
     */
    public void setTurtleAngle(double angle) {
        myTurtles.get(turtleIndex).setAngle(angle);
    }

    /**
     * setVariableList() - setter for the variable list.
     * @param variableList list of variables.
     */
    public void setVariableList(ObservableList<String> variableList){
        variablesPage.setList(variableList);
    }

    /**
     * setCommandList() - setter for the command list.
     * @param commandList list of possible commands.
     */
    public void setCommandList(ObservableList<String> commandList){
        commandsPage.setList(commandList);
    }

    /**
     * getCommand() - getter for the String the user inputs.
     * @return String user's input.
     */
    public String getCommand() {
        return command;
    }

    /**
     * resetCommand() - resets the command to null.
     */
    public void resetCommand() {
        command = "";
    }

    /**
     * clearScreen() - clears the screen and resets the animation.
     */
    public void clearScreen() {
        playAnimation();
    }

    /**
     * show() - shows the turtle.
     */
    public void show() {
        myTurtles.get(turtleIndex).setVisible(true);
    }

    /**
     * hide() - hides the turtle.
     */
    public void hide() {
        myTurtles.get(turtleIndex).setVisible(false);
    }

    /**
     * addInputHistory() - add a String for the history of the input.
     */
    public void addInputHistory(String history) {
        inputHistory.setText(inputHistory.getText() + '\n' + history);
    }

    /**
     * addUserInput() - add a String to the actual user inputl; acts like a terminal.
     */
    public void addUserInput(String input) {
        userInputText.setText(userInputText.getText() + '\n' + input);
    }

    /**
     * addExecutedHistory() - add a String to the executed commands.
     */
    public void addExecutedHistory(String executed) {

        if(executed.isEmpty()) {
            executedHistory.setText(executedHistory.getText());
        }
        else{
            executedHistory.setText(executedHistory.getText() + '\n' + executed);
            }
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

    /**
     * playHistory() - getter for the history playback status.
     * @return boolean history playback status.
     */
    public boolean playHistory(){
        return history;
    }

    /**
     * stopHistory() - stops the history playback.
     */
    public void stopHistory(){
        history = false;
    }

    /**
     * draw() - method to draw a line.
     */
    public void draw(String test) {
        /*
        Turtle currTurtle = myTurtles.get(turtleIndex);
        if ((Math.abs(currTurtle.getOldXCoordinate() - currTurtle.getXCoordinate())) < 500
            && (Math.abs(currTurtle.getOldYCoordinate() - currTurtle.getYCoordinate())) < 500) {
            if (currTurtle.getPen()) {
                Line line = new Line();
                line.setStartX(currTurtle.getOldXCoordinate());
                line.setStartY(currTurtle.getOldYCoordinate());
                line.setEndX(currTurtle.getXCoordinate());
                line.setEndY(currTurtle.getYCoordinate());
                line.setFill(penColor); // ***
                parserField.getChildren().add(line);
            }
        }

         */
    }

    private void start() {
        myStage = new Stage();
        playAnimation();
    }

    private void playAnimation() {
        setUpEnvironment();
        myStage.setScene(myScene);
        String stylesheet = String.format("%s%s", RESOURCE_FOLDER, STYLESHEET);
        myScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
        myStage.show();
        myStage.setResizable(false);
    }

    private void setCommand(String command) {
        this.command = command;
    }

    public void setLanguageOptions(Collection<String> options){
        languageBox.getItems().clear();
        languageBox.getItems().addAll(options);
    }
    public ObjectProperty<String> getLanguageProperty(){
        return languageBox.valueProperty();
    }

    private void setUpEnvironment() {

        myTurtles = new ArrayList<>();

        myParserPane = new Pane();
        myParserPane.setMinSize(FIELD_SIZE, FIELD_SIZE);
        parserField = new Group();
        Node initialTurtle = createTurtle(TURTLE_IMAGE, turtleIndex);
        parserField.getChildren().add(initialTurtle);

        myParserPane.getChildren().addAll(parserField);

        HBox inputBox = setUpInputBox();

        BorderPane myLayout = new BorderPane();
        myLayout.setBottom(inputBox);
        BorderPane.setAlignment(inputBox, Pos.CENTER);
        Node envButtons = createEnvButtons();
        myLayout.setTop(envButtons);
        BorderPane.setAlignment(envButtons, Pos.CENTER);
        Node textArea = createEnvTextArea();
        myLayout.setLeft(textArea);
        BorderPane.setAlignment(textArea, Pos.CENTER);
        Node envLists = createEnvLists();
        myLayout.setRight(envLists);


        BorderPane.setAlignment(envLists, Pos.CENTER);
        myLayout.setCenter(myParserPane);
        BorderPane.setAlignment(parserField, Pos.CENTER);

        myScene = new Scene(myLayout);
    }

    private Turtle createTurtle(Image turtleImage, int turtleIndex) {
        Turtle initialTurtle = new visualizer.Turtle(turtleImage, turtleIndex);
        //initialTurtle.layoutXProperty().bind(Bindings.divide(myParserPane.widthProperty(), 2));
        //initialTurtle.layoutYProperty().bind(Bindings.divide(myParserPane.heightProperty(), 2));
        initialTurtle.setTranslateX(initialTurtle.getBoundsInLocal().getMaxX() / -2.0 );
        initialTurtle.setTranslateY(initialTurtle.getBoundsInLocal().getMaxY() / -2.0 );
        myTurtles.add(initialTurtle);
        return initialTurtle;
    }

    private HBox setUpInputBox() {
        HBox inputBox = new HBox(10);
        Pane inputPane = new Pane(inputBox);
        inputPane.setPadding(MARGINS);

        userInputText = new Text(TERMINAL);
        userInputTextArea = new TextArea("");

        ScrollPane userInputScrollPane = createScrollPane(userInputText, NODE_GAP, NODE_GAP, ScrollPane.ScrollBarPolicy.NEVER,
                ScrollPane.ScrollBarPolicy.ALWAYS, true, true, TEXT_INPUT_WIDTH, TEXT_INPUT_SIZE);

        HBox.setHgrow(userInputScrollPane, Priority.ALWAYS);
        HBox.setHgrow(userInputTextArea, Priority.ALWAYS);

        Button inputButton = createButton("ENTER", 0, 0, inputBox);
        inputButton.setOnAction(event -> {
            String newText = userInputTextArea.getText();
            inputHistory.setText(inputHistory.getText() + '\n' + newText);
            userInputText.setText(userInputText.getText() + '\n' + "(command entered)");
            userInputTextArea.clear();
            setCommand(newText);
        });
        inputBox.getChildren().addAll(userInputTextArea, userInputScrollPane);
        return inputBox;
    }

    private Node createEnvLists() {
        VBox envLists = new VBox(NODE_GAP);

        Pane envListPane = new Pane(envLists);
        envLists.prefHeightProperty().bind(envListPane.heightProperty());
        envLists.setPadding(MARGINS);
        commandsPage = new Page();
        variablesPage = new Page();
        envColorChoice = new ColorChoice(BACKGROUND_COLOR, MAX_RGB, MAX_RGB, MAX_RGB);
        penColorChoice = new ColorChoice(PEN_COLOR, 0, 0, 0);
        HBox colorButtons = createColorButtons();
        envLists.getChildren().addAll(commandsPage.getScrollPane(), variablesPage.getScrollPane(),
                envColorChoice.getVisual(), penColorChoice.getVisual(), colorButtons);
        return envLists;
    }

    private Node createEnvTextArea() {
        VBox inputArea = new VBox(NODE_GAP);

        Pane textArea = new Pane(inputArea);
        inputArea.prefHeightProperty().bind(textArea.heightProperty());

        inputHistory = new Text(USER_INPUT_HISTORY);
        executedHistory = new Text(COMMAND_EXECUTION_HISTORY);
        ScrollPane inputScrollPane = createScrollPane(inputHistory, 0, 0, ScrollPane.ScrollBarPolicy.NEVER,
                ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        VBox.setVgrow(inputScrollPane, Priority.ALWAYS);
        ScrollPane executedScrollPane = createScrollPane(executedHistory, 0, 0, ScrollPane.ScrollBarPolicy.NEVER,
                ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        VBox.setVgrow(executedScrollPane, Priority.ALWAYS);
        inputArea.getChildren().addAll(inputScrollPane, executedScrollPane);
        return inputArea;
    }

    private Node createEnvButtons() {
        HBox buttons = new HBox(NODE_GAP);
        Pane buttonPane = new Pane(buttons);
        buttons.prefWidthProperty().bind(buttonPane.widthProperty());
        Button resetButton = createButton("RESET", 0, 0, buttons);
        HBox.setHgrow(resetButton, Priority.ALWAYS);
        resetButton.setOnAction(event -> playAnimation());
        Button replayParser = createButton("REPLAY", 0, 0, buttons);
        HBox.setHgrow(replayParser, Priority.ALWAYS);
        replayParser.setOnAction(event -> replayButtonPressed());
        Button helpButton = createButton("HELP", 0, 0, buttons);
        HBox.setHgrow(helpButton, Priority.ALWAYS);
        helpButton.setOnAction(event -> helpButton());
        Button turtleImageFileButton = createButton("NEW TURTLE IMAGE", 0, 0,  buttons);
        HBox.setHgrow(turtleImageFileButton, Priority.ALWAYS);
        languageBox = createLanguageBox();
        buttons.getChildren().add(languageBox);
        HBox.setHgrow(languageBox, Priority.ALWAYS);
        //myScene = new Scene(myGroup, ENVIRONMENT_WIDTH, ENVIRONMENT_HEIGHT, ENVIRONMENT_BACKGROUND);
        turtleImageFileButton.setOnAction(event -> turtleImageButton());
        return buttonPane;
    }

    private void replayButtonPressed() {
        history = true;
    }

    private HBox createColorButtons() {
        HBox cb = new HBox(NODE_GAP);
        Button envColor = new Button("BG COLOR");
        envColor.setOnAction(event -> envColorButton());
        Button penColor = new Button("PEN COLOR");
        penColor.setOnAction(event -> penColorButton());
        cb.getChildren().addAll(envColor, penColor);
        return cb;
    }
    private void helpButton() {
        HelpPage popup = new HelpPage();
    }

    private ComboBox createLanguageBox() {
        ComboBox lb = new ComboBox();
        //lb.setMaxWidth(Double.MAX_VALUE);
        lb.setPromptText("Select Language");
        return lb;
    }

    private Button createButton(String text, int x, int y, HBox buttons) {
        Button myButton = new Button();
        myButton.setMaxWidth(Double.MAX_VALUE);
        myButton.setText(text);
        buttons.getChildren().add(myButton);
        return myButton;
    }

    private ScrollPane createScrollPane(Node text, int x, int y, ScrollPane.ScrollBarPolicy hbar,
        ScrollPane.ScrollBarPolicy vbar, boolean fitHeight, boolean fitWidth, int width, int height) {
        ScrollPane scrollPane = new ScrollPane(text);
        scrollPane.setHbarPolicy(hbar);
        scrollPane.setVbarPolicy(vbar);
        //scrollPane.setFitToHeight(fitHeight);
        scrollPane.setFitToWidth(fitWidth);
        scrollPane.setMinHeight(0);
        return scrollPane;
    }

    private void setTurtleImage(File imageFile){
        Image newTurtleImage = new Image(imageFile.toURI().toString());
        Turtle currentTurtle = myTurtles.get(turtleIndex);
        parserField.getChildren().remove(currentTurtle);
        myTurtles.remove(turtleIndex);
        Turtle newTurtle = createTurtle(newTurtleImage, turtleIndex);
        //myTurtles.add(turtleIndex,newTurtle);
        parserField.getChildren().add(newTurtle);
    }

    private void turtleImageButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(myStage);
        if (selectedFile == null) {
            System.out.println("You must select a file");
            return;
        }
        setTurtleImage(selectedFile);
    }

    private void envColorButton() {
        int R = envColorChoice.getR();
        int G = envColorChoice.getG();
        int B = envColorChoice.getB();
        myParserPane.setBackground(new Background(new BackgroundFill(Color.color(R/MAX_RGB, G/MAX_RGB, B/MAX_RGB), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void penColorButton() {
        int R = penColorChoice.getR();
        int G = penColorChoice.getG();
        int B = penColorChoice.getB();
        Color penColor = Color.color(R / MAX_RGB, G / MAX_RGB, B / MAX_RGB);
    }
}