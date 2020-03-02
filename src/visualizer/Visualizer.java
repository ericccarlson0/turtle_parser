package visualizer;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Slider;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
    private static final double FRAMES_PER_SECOND = 60;
    private static final double STEPS_PER_SECOND = 1;
    private static final double TURTLE_SPEED_FPS = 100;

    private Stage myStage;
    private Scene myScene;

    private Pane myParserPane;
    private Group parserField;
    private Group trailsGroup;
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
    private Timeline myAnimation;
    private Queue<Transition> myTransitionQueue;
    private Queue<Transition> mylastExecuted;
    private DoubleProperty speedProperty;
    /**
     * visualizer() - constructor for the visualizer.
     */
    public Visualizer() {
        myTransitionQueue = new LinkedList<>();
        start();
    }
    public void run(){
        myAnimation = new Timeline();
        myAnimation.setCycleCount(Timeline.INDEFINITE);
        Iterator<Transition> transitionIterator = myTransitionQueue.iterator();
        for(Transition transition : myTransitionQueue){
            transition.setOnFinished(event ->{
                if(transitionIterator.hasNext()) {
                    transitionIterator.next().play();
                }else{
                    mylastExecuted = myTransitionQueue;
                    myTransitionQueue = new LinkedList<>();
                }
            });
        }
        if(transitionIterator.hasNext()) {
            System.out.println("playing!");
            transitionIterator.next().play();
        }
    }

    public void setPosition(double startX, double startY, double endX, double endY, double turtles){
        Turtle currentTurlte = myTurtles.get(turtleIndex);

        SequentialTransition seq = new SequentialTransition();
        double length = Math.sqrt(Math.pow(startX-endX,2)+Math.pow(startY-endY,2));
        int segments = length >= 10 ? (int)(length / 10) : 1;
        double lengthPerSegment = length / segments;
        double time = lengthPerSegment / TURTLE_SPEED_FPS;
        System.out.println("" + segments + " " + lengthPerSegment + " " + time);
        for (int i = 0; i < segments; i++) {
            double dX = endX - startX;
            double dY = endY - startY;
            double adjustStartX, adjustStartY;
            double tempStartX = startX + (i / ((double)(segments)))  * dX;
            double tempStartY = startY + (i / ((double)(segments))) * dY;
            if(tempStartX >= 0){
                adjustStartX = (FIELD_SIZE / 2.0  +  tempStartX) % FIELD_SIZE - FIELD_SIZE / 2.0;

            } else {
                adjustStartX = (FIELD_SIZE / 2.0) - (FIELD_SIZE / 2.0 - tempStartX) % FIELD_SIZE;
            }
            if(tempStartY >= 0){
                adjustStartY = (FIELD_SIZE / 2.0 + tempStartY) % FIELD_SIZE - FIELD_SIZE / 2.0;
            } else {
                adjustStartY = (FIELD_SIZE / 2.0) - (FIELD_SIZE / 2.0 - tempStartY) % FIELD_SIZE;
            }
            double adjustEndX = adjustStartX + (1 / ((double)(segments))) * dX;
            double adjustEndY = adjustStartY + (1 / ((double)(segments))) * dY;

            Line line = new Line();
            line.setStartX(adjustStartX);
            line.setStartY(adjustStartY);
            line.setEndX(adjustEndX);
            line.setEndY(adjustEndY);
            Line displayLine = new Line();
            trailsGroup.getChildren().add(displayLine);
            displayLine.setOpacity(0.0);
            displayLine.setEndX(adjustEndX);
            displayLine.setEndY(adjustEndY);
            displayLine.setStartY(adjustStartY);
            displayLine.setStartX(adjustStartX);
            displayLine.layoutXProperty().bind(Bindings.divide(myParserPane.widthProperty(), 2.0));
            displayLine.layoutYProperty().bind(Bindings.divide(myParserPane.heightProperty(), 2.0));
            PathTransition emptyTransition = new PathTransition();
            emptyTransition.setDuration(Duration.seconds(time));
            emptyTransition.setOnFinished(event -> {
                    displayLine.setOpacity(1.0);
                System.out.println(currentTurlte.getBoundsInParent().getCenterX());
                System.out.println(currentTurlte.getBoundsInParent().getCenterY());
            });
            emptyTransition.setNode(currentTurlte);
            emptyTransition.setPath(line);

            seq.getChildren().add(emptyTransition);
        }
            seq.rateProperty().bind(speedProperty);
            myTransitionQueue.add(seq); //pathTransition);//allTogether);

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
     */
    public void setTurtleAngle(double startAngle, double endAngle, double duration) {
        RotateTransition rt = new RotateTransition(Duration.millis(1), myTurtles.get(turtleIndex));
        rt.setFromAngle(90 + startAngle);
        rt.setToAngle(90 + endAngle);
        rt.setCycleCount(1);
        myTransitionQueue.add(rt);
        //myTurtles.get(turtleIndex).setAngle(angle);
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
    public void clearScreen(double temp) {
        System.out.println("clearing");
        ScaleTransition pathTransition = new ScaleTransition();
        pathTransition.setDuration(Duration.millis(1));
        pathTransition.setNode(myTurtles.get(turtleIndex));
        pathTransition.setFromX(1.0);
        pathTransition.setToX((1.0));
        pathTransition.setCycleCount(1);
        pathTransition.setOnFinished( event -> {
            trailsGroup.getChildren().clear();
            System.out.println("DONE");
        });
        myTransitionQueue.add(pathTransition);
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
    public void hide(double hide, double duration) {
        System.out.println("hiding");
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1));
        pathTransition.setOnFinished( event -> {
            System.out.println("FINISHED!");
            System.out.println("hiding? " + (hide != 0.0));
            myTurtles.get(turtleIndex).setVisible(hide != 0.0);
        });
        myTransitionQueue.add(pathTransition);
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
        myParserPane.setPadding(new Insets(50, 50, 50, 50));
        myParserPane.setMinSize(FIELD_SIZE, FIELD_SIZE);
        myParserPane.setPrefSize(FIELD_SIZE, FIELD_SIZE);
        parserField = new Group();
        trailsGroup = new Group();
        Turtle initialTurtle = createTurtle(TURTLE_IMAGE, turtleIndex);
        parserField.getChildren().add(initialTurtle);
        initialTurtle.setTranslateX(-20); //FIXME
        initialTurtle.setTranslateY(-20);

        myParserPane.getChildren().addAll(parserField, trailsGroup);

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
        initialTurtle.layoutXProperty().bind(Bindings.add(Bindings.divide(myParserPane.widthProperty(),2), Bindings.divide(initialTurtle.fitWidthProperty(), -1.0 )));
        initialTurtle.layoutYProperty().bind(Bindings.add(Bindings.divide(myParserPane.heightProperty(), 2), Bindings.divide(initialTurtle.fitHeightProperty(), -1.0)));
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

        Button inputButton = createButton("ENTER", event -> {
            String newText = userInputTextArea.getText();
            inputHistory.setText(inputHistory.getText() + '\n' + newText);
            userInputText.setText(userInputText.getText() + '\n' + "(command entered)");
            userInputTextArea.clear();
            setCommand(newText);
        });
        inputBox.getChildren().addAll(inputButton, userInputTextArea, userInputScrollPane);
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
        Slider speedSlider = new Slider(0, 2, 1);
        speedProperty = speedSlider.valueProperty();
        envLists.getChildren().addAll(commandsPage.getScrollPane(), variablesPage.getScrollPane(),
                envColorChoice.getVisual(), penColorChoice.getVisual(), colorButtons, speedSlider);

        return envLists;
    }

    private Node createEnvTextArea() {
        VBox inputArea = new VBox(NODE_GAP);
        inputArea.setPrefWidth(300);
        inputArea.setMaxWidth(300);

        Pane textArea = new Pane(inputArea);
        inputArea.prefHeightProperty().bind(textArea.heightProperty());

        inputHistory = new Text(USER_INPUT_HISTORY);
        executedHistory = new Text(COMMAND_EXECUTION_HISTORY);
        ScrollPane inputScrollPane = createScrollPane(inputHistory, 0, 0, ScrollPane.ScrollBarPolicy.ALWAYS,
                ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        inputScrollPane.prefViewportWidthProperty().bind(inputArea.widthProperty());
        VBox.setVgrow(inputScrollPane, Priority.ALWAYS);
        ScrollPane executedScrollPane = createScrollPane(executedHistory, 0, 0, ScrollPane.ScrollBarPolicy.ALWAYS,
                ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        executedScrollPane.prefViewportWidthProperty().bind(inputArea.widthProperty());
        VBox.setVgrow(executedScrollPane, Priority.ALWAYS);
        inputScrollPane.prefViewportHeightProperty().bindBidirectional(executedScrollPane.prefViewportHeightProperty());
        inputArea.getChildren().addAll(inputScrollPane, executedScrollPane);
        return inputArea;
    }

    private Node createEnvButtons() {
        HBox buttons = new HBox(NODE_GAP);
        Pane buttonPane = new Pane(buttons);
        buttons.prefWidthProperty().bind(buttonPane.widthProperty());

        Button resetButton = createButton("RESET", event -> { playAnimation(); });
        HBox.setHgrow(resetButton, Priority.ALWAYS);

        Button replayParser = createButton("REPLAY", event -> replayButtonPressed());
        HBox.setHgrow(replayParser, Priority.ALWAYS);

        Button helpButton = createButton("HELP", event -> { helpButton(); });
        HBox.setHgrow(helpButton, Priority.ALWAYS);

        Button turtleImageFileButton = createButton("NEW TURTLE IMAGE", event -> turtleImageButton());
        HBox.setHgrow(turtleImageFileButton, Priority.ALWAYS);

        languageBox = createLanguageBox();
        HBox.setHgrow(languageBox, Priority.ALWAYS);

        buttons.getChildren().addAll(resetButton, replayParser, helpButton, turtleImageFileButton, languageBox);
        return buttonPane;
    }

    private void replayButtonPressed() {
        myTransitionQueue = mylastExecuted;
        run();
    }

    private HBox createColorButtons() {
        HBox cb = new HBox(NODE_GAP);
        Button envColor = createButton("BG COLOR", event -> envColorButton());
        Button penColor = createButton("PEN COLOR", event -> penColorButton());
        cb.getChildren().addAll(envColor, penColor);
        return cb;
    }

    private void helpButton() {
        HelpPage popup = new HelpPage();
    }

    private ComboBox createLanguageBox() {
        ComboBox lb = new ComboBox();
        lb.setPromptText("Select Language");
        return lb;
    }

    private Button createButton(String text, EventHandler<ActionEvent> onClicked) {
        Button myButton = new Button();
        myButton.setMaxWidth(Double.MAX_VALUE);
        myButton.setText(text);
        myButton.setOnAction(onClicked);
        return myButton;
    }

    private ScrollPane createScrollPane(Node text, int x, int y, ScrollPane.ScrollBarPolicy hbar,
        ScrollPane.ScrollBarPolicy vbar, boolean fitHeight, boolean fitWidth, int width, int height) {
        ScrollPane scrollPane = new ScrollPane(text);
        scrollPane.setHbarPolicy(hbar);
        scrollPane.setVbarPolicy(vbar);
        //scrollPane.setFitToHeight(false);
        //scrollPane.setFitToWidth(false);
        scrollPane.setMinHeight(0);
        return scrollPane;
    }

    private void setTurtleImage(File imageFile){
        myTurtles.get(turtleIndex).setImage(new Image(imageFile.toURI().toString()));
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