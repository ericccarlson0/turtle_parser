package visualizer;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;

import javafx.animation.*;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
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

import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    private static final String TITLE_TEXT = " SLOGO ";
    private static final int SCROLLPANE_SIZE = 250;
    private static final int TEXT_INPUT_WIDTH = 400;
    private static final int TEXT_INPUT_SIZE = 150;
    private static final String TURTLE_FILE = "images/turtle.jpg";
    private static final Image TURTLE_IMAGE = new Image(TURTLE_FILE);
    public static final int MAX_RGB = 255;
    private static final double TURTLE_SPEED_FPS = 100;
    private static final double lineStrokeWidthIncrementSize = 0.3;

    private Stage myStage;
    private Scene myScene;

    private Pane myParserPane;
    private Group parserField;
    private Group trailsGroup;
    private Map<Double, Turtle> myTurtles;
    private int turtleIndex = 0;
    private Text executedHistory;
    private ScrollPane inputPane;
    private VBox inputHistory;
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
    private DoubleProperty strokeWidthChosen = new SimpleDoubleProperty(1);

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
            transitionIterator.next().play();
        }
    }

    public void setPosition(List<List<Double>> args){
        ParallelTransition root = new ParallelTransition();
        for(List<Double> arg : args) {
            System.out.println("an arg!");
            Turtle currentTurtle = currentTurtle = myTurtles.get(arg.get(0).doubleValue());
            if(currentTurtle == null){
                //e.printStackTrace();
                Turtle initialTurtle = createTurtle(TURTLE_IMAGE, turtleIndex);
                parserField.getChildren().add(initialTurtle);
                initialTurtle.setTranslateX(-20); //FIXME
                initialTurtle.setTranslateY(-20);
                myTurtles.put(arg.get(0), initialTurtle);
                currentTurtle = initialTurtle;
                System.out.println("initial turtle: " + initialTurtle);
            }
            double startX = arg.get(1);
            double startY = arg.get(2);
            double endX = arg.get(3);
            double endY = arg.get(4);
            SequentialTransition seq = new SequentialTransition();
            double length = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
            int segments = length >= 10 ? (int) (length / 10) : 1;
            double lengthPerSegment = length / segments;
            double time = lengthPerSegment / TURTLE_SPEED_FPS;
            for (int i = 0; i < segments; i++) {
                double dX = endX - startX;
                double dY = endY - startY;
                double adjustStartX, adjustStartY;
                double tempStartX = startX + (i / ((double) (segments))) * dX;
                double tempStartY = startY + (i / ((double) (segments))) * dY;
                if (tempStartX >= 0) {
                    adjustStartX = (FIELD_SIZE / 2.0 + tempStartX) % FIELD_SIZE - FIELD_SIZE / 2.0;

                } else {
                    adjustStartX = (FIELD_SIZE / 2.0) - (FIELD_SIZE / 2.0 - tempStartX) % FIELD_SIZE;
                }
                if (tempStartY >= 0) {
                    adjustStartY = (FIELD_SIZE / 2.0 + tempStartY) % FIELD_SIZE - FIELD_SIZE / 2.0;
                } else {
                    adjustStartY = (FIELD_SIZE / 2.0) - (FIELD_SIZE / 2.0 - tempStartY) % FIELD_SIZE;
                }
                double adjustEndX = adjustStartX + (1 / ((double) (segments))) * dX;
                double adjustEndY = adjustStartY + (1 / ((double) (segments))) * dY;

                Line line = new Line();
                line.setStartX(adjustStartX);
                line.setStartY(adjustStartY);
                line.setEndX(adjustEndX);
                line.setEndY(adjustEndY);
                Line displayLine = new Line();
                displayLine.strokeWidthProperty().bind(strokeWidthChosen);
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
                    displayLine.strokeWidthProperty().unbind();
                    displayLine.setOpacity(1.0);
                });
                System.out.println(currentTurtle);
                emptyTransition.setNode(currentTurtle);
                emptyTransition.setPath(line);

                seq.getChildren().add(emptyTransition);
            }
            root.getChildren().add(seq);
        }
            root.rateProperty().bind(speedProperty);
            myTransitionQueue.add(root); //pathTransition);//allTogether);

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
    public void setTurtleAngle(List<List<Double>> args){//double startAngle, double endAngle, double duration) {
        ParallelTransition transtion = new ParallelTransition();
        for(List<Double> arg : args) {
            RotateTransition rt = new RotateTransition(Duration.millis(1), myTurtles.get(arg.get(0)));
            double startAngle = arg.get(1);
            double endAngle = arg.get(2);
            rt.setFromAngle(90 + startAngle);
            rt.setToAngle(90 + endAngle);
            rt.setCycleCount(1);
            transtion.getChildren().add(rt);
        }
        myTransitionQueue.add(transtion);
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
    public void clearScreen(List<List<Double>> args) {
        ParallelTransition transition = new ParallelTransition();
        for(List<Double> arg : args) {
            ScaleTransition pathTransition = new ScaleTransition();
            pathTransition.setDuration(Duration.millis(1));
            pathTransition.setCycleCount(1);
            pathTransition.setOnFinished(event -> {
                trailsGroup.getChildren().clear();
                System.out.println("DONE");
            });
            transition.getChildren().add(pathTransition);
        }
        myTransitionQueue.add(transition);
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
    public void hide(List<List<Double>> args) {
        ParallelTransition pt = new ParallelTransition();
        for(List<Double> arg : args) {
            ScaleTransition pathTransition = new ScaleTransition();
            pathTransition.setDuration(Duration.millis(1));
            pathTransition.setOnFinished(event -> {
                myTurtles.get(arg.get(0)).setVisible(arg.get(1) == 0.0);
            });
            pt.getChildren().add(pathTransition);
        }
        myTransitionQueue.add(pt);
    }

    /**
     * addInputHistory() - add a String for the history of the input.
     */
    public void addInputHistory(String history) {


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

        myTurtles = new HashMap<>();

        myParserPane = new Pane();
        myParserPane.setId("turtle-UI");
        myParserPane.setPadding(new Insets(50, 50, 50, 50));
        myParserPane.setMinSize(FIELD_SIZE, FIELD_SIZE);
        myParserPane.setPrefSize(FIELD_SIZE, FIELD_SIZE);
        parserField = new Group();
        trailsGroup = new Group();
        Turtle initialTurtle = createTurtle(TURTLE_IMAGE, turtleIndex);
        myTurtles.put(0.0, initialTurtle);
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
            Button newCommand = new Button(newText);
            newCommand.setOnAction(e->setCommand(newCommand.getText()));
            inputHistory.getChildren().add(newCommand);
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
        Slider speedSlider = new Slider(0, 4, 2);
        speedProperty = speedSlider.valueProperty();

        Button increaseLineStrokeWidthButton = createButton("+", event -> changeLineStrokeWidth(lineStrokeWidthIncrementSize));
        Button decreaseLineStrokeWidthButton = createButton("-", event -> changeLineStrokeWidth(-lineStrokeWidthIncrementSize));
        Line strokeWidthVisualLine = new Line();
        Text strokeWidthText = new Text("Trail Width");
        strokeWidthVisualLine.strokeWidthProperty().bind(strokeWidthChosen);
        strokeWidthVisualLine.setEndX(20);
        strokeWidthVisualLine.setStartX(0);

        HBox strokeWidthHbox = new HBox(30);
        strokeWidthHbox.getChildren().addAll(strokeWidthText,decreaseLineStrokeWidthButton,increaseLineStrokeWidthButton,strokeWidthVisualLine);
        strokeWidthHbox.setAlignment(Pos.CENTER);

        envLists.getChildren().addAll(commandsPage.getScrollPane(), variablesPage.getScrollPane(),
                envColorChoice.getVisual(), penColorChoice.getVisual(), colorButtons, speedSlider,strokeWidthHbox);

        return envLists;
    }

    private Node createEnvTextArea() {
        VBox inputArea = new VBox(NODE_GAP);
        inputArea.setPrefWidth(300);
        inputArea.setMaxWidth(300);

        Pane textArea = new Pane(inputArea);
        inputArea.prefHeightProperty().bind(textArea.heightProperty());

        inputHistory = new VBox();
        inputHistory.getChildren().add(new Text(USER_INPUT_HISTORY));
        executedHistory = new Text(COMMAND_EXECUTION_HISTORY);
        inputPane = createScrollPane(inputHistory, 0, 0, ScrollPane.ScrollBarPolicy.ALWAYS,
                ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        inputPane.prefViewportWidthProperty().bind(inputArea.widthProperty());
        VBox.setVgrow(inputPane, Priority.ALWAYS);
        ScrollPane executedScrollPane = createScrollPane(executedHistory, 0, 0, ScrollPane.ScrollBarPolicy.ALWAYS,
                ScrollPane.ScrollBarPolicy.ALWAYS, true, true, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        executedScrollPane.prefViewportWidthProperty().bind(inputArea.widthProperty());
        VBox.setVgrow(executedScrollPane, Priority.ALWAYS);
        inputPane.prefViewportHeightProperty().bindBidirectional(executedScrollPane.prefViewportHeightProperty());
        inputArea.getChildren().addAll(inputPane, executedScrollPane);

        Button fdButton = new Button("FD");
        fdButton.setOnAction(e -> setCommand("fd 1"));
        addTimer(fdButton, "fd 1");
        Button bkButton = new Button("BK");
        addTimer(bkButton, "bk 1");
        Button rtButton = new Button("RT");
        addTimer(rtButton, "rt 1");
        Button ltButton = new Button("LT");
        addTimer(ltButton, "lt 1");
        inputArea.getChildren().addAll(fdButton,bkButton,rtButton,ltButton);

        return inputArea;
    }

    private void addTimer(Button button, String command) {

        final AnimationTimer timer = new AnimationTimer() {
            long lastUpdate = 0;
            @Override
            public void handle(long time) {
                if (this.lastUpdate > 100) {
                    setCommand(command);
                }
                this.lastUpdate = time;
            }
        };
        button.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                    timer.start();
                } else {
                    timer.stop();
                }
            }
        });
    }

    private Node createEnvButtons() {
        HBox buttons = new HBox(NODE_GAP);
        languageBox = createLanguageBox();
        Text title = new Text(TITLE_TEXT);
        title.setId("title-text");

        Pane buttonPane = new Pane(buttons);
        buttons.prefWidthProperty().bind(buttonPane.widthProperty());

        Button resetButton = createButton("RESET", event -> { myStage.close(); start(); });
        HBox.setHgrow(resetButton, Priority.ALWAYS);

        Button replayParser = createButton("REPLAY", event -> replayButtonPressed());
        HBox.setHgrow(replayParser, Priority.ALWAYS);

        Button helpButton = createButton("HELP", event -> { helpButton(); });
        HBox.setHgrow(helpButton, Priority.ALWAYS);

        Button turtleImageFileButton = createButton("NEW TURTLE IMAGE", event -> turtleImageButton());
        HBox.setHgrow(turtleImageFileButton, Priority.ALWAYS);

        languageBox = createLanguageBox();
        HBox.setHgrow(languageBox, Priority.ALWAYS);

        buttons.getChildren().addAll(title, resetButton, replayParser, helpButton,
            turtleImageFileButton, languageBox);
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


    private Rectangle createField(int x, int y, int width, int height) {
        Rectangle fld = new Rectangle(x, y, width, height);
        fld.setFill(Color.color(1.0, 1.0, 1.0));
        return fld;
    }

    private Shape createBackground(int x, int y, int width, int height, int border) {
      Shape bg = new Rectangle(x - border/2, y - border/2, width + border, height + border);
      bg.setId("turtle-UI");
      return bg;
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
        myTurtles.get((double) turtleIndex).setImage(new Image(imageFile.toURI().toString()));
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

    private void changeLineStrokeWidth(double incrementSize){
        strokeWidthChosen.set(strokeWidthChosen.doubleValue() + incrementSize);
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