package visualizer;


import java.awt.geom.Point2D;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import java.util.ResourceBundle;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.Animation;

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

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
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
import visualizer.languageSensitive.TextElement;
import visualizer.languageSensitive.TextElementButton;
import visualizer.languageSensitive.TextElementText;

/**
 * visualizer.java - a class for managing the frontend.
 * @author  Lorne Zhang, Eric Carlson
 * @version 1.0
 */
public class Visualizer {

    private static final String RESOURCE_FOLDER = "/stylesheets";
    private static final String STYLESHEET = "/default.css";
    private static final String TURTLE_FILE = "images/turtle.jpg";
    private static final Image TURTLE_IMAGE = new Image(TURTLE_FILE);
    private static final String BACKGROUND_COLOR = "BG_COLOR";
    private static final String PEN_COLOR = "PEN_COLOR";
    private static final String USER_INPUT_HEADING = "INPUT_HISTORY";
    private static final String COMMAND_EXECUTION_HEADING = "EXECUTION_HISTORY";
    public static final String COMMAND_ENTERED = "COMMAND_ENTERED";
    public static final String PEN_STROKE = "PEN_STROKE";
    private static final String TERMINAL = "TERMINAL";
    private static final String TITLE_TEXT = " SLOGO ";
    private static final Insets MARGINS = new Insets(10,10,10,10);
    private static final double FIELD_SIZE = 500;
    private static final int SCROLLPANE_SIZE = 250;
    private static final int TEXT_INPUT_WIDTH = 400;
    private static final int TEXT_INPUT_SIZE = 150;
    public static final int MAX_RGB = 255;
    private static final double TURTLE_SPEED_FPS = 100;
    private static final double STROKE_INCREMENT_SIZE = 0.3;
    public static final int HISTORY_AREA_WIDTH = 300;
    private static final int NODE_GAP = 8;

    private Stage myStage;
    private Scene myScene;

    private Pane myParserPane;
    private Group parserField;
    private Group trailsGroup;
    private Map<Integer, Turtle> myTurtles;
    private int turtleIndex = 0;
    private double leadTurtleIndex = 0;
    private VBox executedHistory;
    private VBox inputHistory;
    private ScrollPane inputPane;
    private VBox userInputBox;
    private VBox summaryBox;
    private TextArea userInputTextArea;
    private ColorChoice envColorChoice;
    private ColorChoice penColorChoice;
    private String currentInput = "";
    private Page variablesPage;
    private Page commandsPage;
    private double TURTLE_IMAGE_CENTER = 20;
    private ComboBox<String> myLanguageBox;
    private Timeline myAnimation;
    private Queue<Transition> myTransitionQueue;
    private Queue<Transition> myLastExecuted;

    private List<TextElement> myTextElements;
    private Map<String, String> languageTagMap;

    private DoubleProperty speedProperty;
    private DoubleProperty strokeWidth = new SimpleDoubleProperty(1);

    /**
     * visualizer() - constructor for the visualizer.
     */
    public Visualizer() {
        myTransitionQueue = new LinkedList<>();
        start();
    }

    public void run() {
        myAnimation = new Timeline();
        myAnimation.setCycleCount(Timeline.INDEFINITE);
        Iterator<Transition> transitionIterator = myTransitionQueue.iterator();
        for (Transition transition : myTransitionQueue){
            transition.setOnFinished(event -> {
                if (transitionIterator.hasNext()) {
                    transitionIterator.next().play();
                } else {
                    myLastExecuted = myTransitionQueue;
                    myTransitionQueue = new LinkedList<>();
                }
            });
        }
        if (transitionIterator.hasNext()) {
            System.out.println("PLAYING!");
            transitionIterator.next().play();
        }
    }
    public void setPenSize(double size){
        ScaleTransition dummyTransition = new ScaleTransition();
        dummyTransition.setDuration(Duration.millis(1));
        dummyTransition.setCycleCount(1);
        dummyTransition.setOnFinished(event -> {
            strokeWidth.setValue(size);
        });
        myTransitionQueue.add(dummyTransition);
    }

    public void setPosition(List<Integer> ids, List<Double> startXs, List<Double> startYs, List<Double> endXs, List<Double> endYs) {
        ParallelTransition root = new ParallelTransition();
        //TODO: Throw exception if sizes don't align
        Iterator<Integer> idIterator = ids.iterator();
        Iterator<Double> startXIterator = startXs.iterator();
        Iterator<Double> startYIterator = startYs.iterator();
        Iterator<Double> endXIterator = endXs.iterator();
        Iterator<Double> endYIterator = endYs.iterator();
        while (idIterator.hasNext()) {
            root.getChildren().add(getSinglePositionTransition(idIterator.next(), startXIterator.next(), startYIterator.next(), endXIterator.next(), endYIterator.next()));
        }
        root.rateProperty().bind(speedProperty);
        myTransitionQueue.add(root);
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
    public void setTurtleAngle(Iterable<Integer> ids, Iterable<Double> startAngles, Iterable<Double> endAngles){
        ParallelTransition transtion = new ParallelTransition();
        //todo: throw exception
        Iterator<Integer> idIterator = ids.iterator();
        Iterator<Double> startAngleIterator = startAngles.iterator();
        Iterator<Double> endAngleIterator = endAngles.iterator();
        while(idIterator.hasNext()) {
            Turtle targetTurtle = fetchTurtle(idIterator.next());
            RotateTransition rt = new RotateTransition(Duration.millis(1), targetTurtle);
            double startAngle = startAngleIterator.next();
            double endAngle = endAngleIterator.next();
            rt.setFromAngle(90 + startAngle);
            rt.setToAngle(90 + endAngle);
            rt.setCycleCount(1);
            transtion.getChildren().add(rt);
        }
        myTransitionQueue.add(transtion);
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
     * getUserInput() - getter for the String the user inputs.
     * @return String user's input.
     */
    public String getUserInput() {
        return currentInput;
    }

    /**
     * resetUserInput() - resets theuser input to null.
     */
    public void resetUserInput() {
        currentInput = "";
    }

    /**
     * clearScreen() - clears the screen and resets the animation.
     */
    public void clearScreen(Iterable<Integer> ids) {
        ParallelTransition transition = new ParallelTransition();
        for(int id : ids) {
            ScaleTransition pathTransition = new ScaleTransition();
            pathTransition.setDuration(Duration.millis(1));
            pathTransition.setCycleCount(1);
            pathTransition.setOnFinished(event -> {

                trailsGroup.getChildren().clear();
                System.out.println("DONE"); // ***
            });
            transition.getChildren().add(transition);
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
    public void hide(Iterable<Integer> ids, Iterable<Boolean> hides) {
        ParallelTransition pt = new ParallelTransition();
        Iterator<Integer> idIterator = ids.iterator();
        Iterator<Boolean> hideIterator = hides.iterator();
        while(idIterator.hasNext()) {

            ScaleTransition pathTransition = new ScaleTransition();
            pathTransition.setDuration(Duration.millis(1));
            pathTransition.setOnFinished(event -> {

                fetchTurtle(idIterator.next()).setVisible(!hideIterator.next());
            });
            pt.getChildren().add(pathTransition);
        }
        myTransitionQueue.add(pt);
    }

    /**
     * addExecutedHistory() - add a String to the executed commands.
     */
    public void addExecutedHistory(String executed) {
        if (! executed.isEmpty()) {
            executedHistory.getChildren().add(new Text(executed));
            // TODO: make this language sensitive by creating a TextElement
        }
    }

    public void setLeadTurtle(List<List<Double>> args) {
        for (List<Double> arg : args) {
            fillSummaryBox(arg.get(0), arg.get(1), arg.get(2), arg.get(3), arg.get(4));
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
        setUpEnvironment();

        myStage.setScene(myScene);
        String stylesheet = String.format("%s%s", RESOURCE_FOLDER, STYLESHEET);
        myScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
        myStage.show();
    }

    private void setCommand(String input) {
        // TODO: can we do more in this method?
        currentInput = input;
    }

    public ObjectProperty<String> getLanguageProperty() {
        return myLanguageBox.valueProperty();
    }

    private void languageBox() {
        String language = myLanguageBox.getValue();
        for (TextElement element: myTextElements) {
            String tag = languageTagMap.get(language);
            element.changeLanguage(tag);
        }
    }

    private void setUpEnvironment() {
        myTurtles = new HashMap<>();
        myTextElements = new ArrayList<>();
        setUpParserPane();

        HBox inputBox = setUpInputBox();
        BorderPane layoutPane = new BorderPane();
        layoutPane.setCenter(myParserPane);
        BorderPane.setAlignment(parserField, Pos.CENTER);
        layoutPane.setBottom(inputBox);
        BorderPane.setAlignment(inputBox, Pos.CENTER);

        Node envButtons = createTopBar();
        layoutPane.setTop(envButtons);
        BorderPane.setAlignment(envButtons, Pos.CENTER);

        Node textArea = createHistoryArea();
        layoutPane.setLeft(textArea);
        BorderPane.setAlignment(textArea, Pos.CENTER);

        Node envLists = createUserDefinedArea();
        layoutPane.setRight(envLists);
        BorderPane.setAlignment(envLists, Pos.CENTER);

        myScene = new Scene(layoutPane);
    }

    /**
     * This method sets up myParserPane, parserField, and trailsGroup, which make up the "parser
     * pane", or the environment in which the turtles are seen and move around.
     */
    private void setUpParserPane() {
        myParserPane = new Pane();
        myParserPane.setId("turtle-UI");
        myParserPane.setPadding(new Insets(50, 50, 50, 50));
        myParserPane.setMinSize(FIELD_SIZE, FIELD_SIZE);
        myParserPane.setPrefSize(FIELD_SIZE, FIELD_SIZE);

        parserField = new Group();
        trailsGroup = new Group();
        // TODO: in the future, TURTLE_IMAGE will not be a constant
        Turtle turt = createTurtle(TURTLE_IMAGE, 0);
        myTurtles.put(0, turt);
        myParserPane.getChildren().addAll(turt, parserField, trailsGroup);
        turt.setTranslateX(-20); // FIXME
        turt.setTranslateY(-20); // FIXME
    }

    private Turtle createTurtle(Image turtleImage, int turtleIndex) {
        Turtle turt = new visualizer.Turtle(turtleImage, turtleIndex);
        turt.layoutXProperty().bind(Bindings.add(Bindings.divide(myParserPane.widthProperty(), 2),
            Bindings.divide(turt.fitWidthProperty(), -1.0)));
        turt.layoutYProperty().bind(Bindings.add(Bindings.divide(myParserPane.heightProperty(), 2),
            Bindings.divide(turt.fitHeightProperty(), -1.0)));
        return turt;
    }

    private HBox setUpInputBox() {
        HBox holder = new HBox(NODE_GAP);
        Pane inputPane = new Pane(holder);
        inputPane.setPadding(MARGINS);

        Text userInputText = new Text(TERMINAL);
        myTextElements.add(new TextElementText(userInputText, TERMINAL));
        userInputBox = new VBox();
        userInputBox.getChildren().add(userInputText);

        userInputTextArea = new TextArea("");
        ScrollPane userInputScrollPane = createScrollPane(userInputBox, ScrollPane.ScrollBarPolicy.ALWAYS,
            ScrollPane.ScrollBarPolicy.NEVER, TEXT_INPUT_WIDTH, TEXT_INPUT_SIZE);
        HBox.setHgrow(userInputScrollPane, Priority.ALWAYS);
        HBox.setHgrow(userInputTextArea, Priority.ALWAYS);

        Button inputButton = createButton("ENTER", event -> inputButton());
        myTextElements.add(new TextElementButton(inputButton, "ENTER"));
        holder.getChildren().addAll(inputButton, userInputTextArea, userInputScrollPane);
        return holder;
    }

    private void inputButton() {
        String text = userInputTextArea.getText();
        Button commandButton = new Button(text);
        commandButton.setOnAction(e -> setCommand(commandButton.getText()));

        // TODO: myTextElements.add(new TextElementButton(commandButton, text));
        inputHistory.getChildren().add(commandButton);

        userInputBox.getChildren().add(new Text(COMMAND_ENTERED));
        userInputTextArea.clear();
        setCommand(text);
    }

    private Node createUserDefinedArea() {
        VBox holder = new VBox(NODE_GAP);

        Pane holderPane = new Pane(holder);
        holder.prefHeightProperty().bind(holderPane.heightProperty());
        holder.setPadding(MARGINS);
        commandsPage = new Page("to", userInputTextArea);
        variablesPage = new Page("set", userInputTextArea);
        initializeSummaryBox();

        envColorChoice = new ColorChoice("□", MAX_RGB, MAX_RGB, MAX_RGB);
        penColorChoice = new ColorChoice("✎", 0, 0, 0);
        HBox colorButtons = createColorButtons();

        Slider speedSlider = new Slider(0, 4, 2);
        speedProperty = speedSlider.valueProperty();

        HBox strokeWidthBox = createStrokeWidthBox();


        holder.getChildren().addAll(commandsPage.getScrollPane(), variablesPage.getScrollPane(),
            summaryBox, envColorChoice.getVisual(), penColorChoice.getVisual(), colorButtons,
            speedSlider, strokeWidthBox);
        return holder;
    }

    private void initializeSummaryBox() {
        summaryBox = new VBox();
        fillSummaryBox(0.0, 0.0, 0.0, 0.0, 0.0);
    }

    private void fillSummaryBox(double id, double x, double y, double heading, double penDown) {
        leadTurtleIndex = (int) id;
        summaryBox.getChildren().clear();
        String defaultTemplate = "%s %.2f";
        Text leadText = new Text("LEAD TURTLE STATISTICS: ");
        Text idText = new Text(String.format("%s %.0f", "ID:\t\t", id));
        Text xText = new Text(String.format(defaultTemplate, "X:\t\t", x));
        Text yText = new Text(String.format(defaultTemplate, "Y:\t\t", y));
        Text headingText = new Text(String.format(defaultTemplate, "HEADING:\t", heading));
        Text penDownText = new Text(String.format("%s %.1f", "PEN DOWN:\t", penDown));
        summaryBox.getChildren().addAll(leadText, idText, xText, yText, headingText, penDownText);
    }

    private Node createHistoryArea() {
        VBox holder = new VBox(NODE_GAP);
        holder.setPrefWidth(HISTORY_AREA_WIDTH);
        holder.setMaxWidth(HISTORY_AREA_WIDTH);
        holder.setPrefHeight(HISTORY_AREA_WIDTH);
        holder.setMaxHeight(HISTORY_AREA_WIDTH);

        Pane holderPane = new Pane(holder);
        holder.prefHeightProperty().bind(holderPane.heightProperty());

        initializeHistoryPanes(holder);
        createMovementButtons(holder);

        return holder;
    }

    private void initializeHistoryPanes (VBox holder) {
        inputHistory = new VBox();
        Text inputHistoryText = new Text(USER_INPUT_HEADING);
        inputHistory.getChildren().add(inputHistoryText);
        myTextElements.add(new TextElementText(inputHistoryText, USER_INPUT_HEADING));

        executedHistory = new VBox();
        Text executedHistoryText = new Text(COMMAND_EXECUTION_HEADING);
        executedHistory.getChildren().add(executedHistoryText);
        myTextElements.add(new TextElementText(executedHistoryText, COMMAND_EXECUTION_HEADING));

        inputPane = createScrollPane(inputHistory, ScrollPane.ScrollBarPolicy.NEVER,
            ScrollPane.ScrollBarPolicy.ALWAYS, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        inputPane.prefViewportWidthProperty().bind(holder.widthProperty());
        VBox.setVgrow(inputPane, Priority.ALWAYS);
        inputPane.setMaxHeight(SCROLLPANE_SIZE);

        ScrollPane executedPane = createScrollPane(executedHistory, ScrollPane.ScrollBarPolicy.NEVER,
            ScrollPane.ScrollBarPolicy.ALWAYS, SCROLLPANE_SIZE, SCROLLPANE_SIZE);
        executedPane.prefViewportWidthProperty().bind(holder.widthProperty());
        VBox.setVgrow(executedPane, Priority.ALWAYS);
        executedPane.setMaxHeight(SCROLLPANE_SIZE);


        inputPane.prefViewportHeightProperty().bindBidirectional(executedPane.prefViewportHeightProperty());
        holder.getChildren().addAll(inputPane, executedPane);
    }

    private HBox createStrokeWidthBox() {
        HBox holder = new HBox(NODE_GAP*3);

        Button increaseStrokeButton = createButton(" + ", event -> changeLineStrokeWidth(
            STROKE_INCREMENT_SIZE));
        Button decreaseStrokeButton = createButton(" - ", event -> changeLineStrokeWidth(
            -STROKE_INCREMENT_SIZE));
        Line strokeWidthVisual = new Line();
        Text strokeWidthText = new Text(PEN_STROKE);
        myTextElements.add(new TextElementText(strokeWidthText, PEN_STROKE));
        strokeWidthVisual.strokeWidthProperty().bind(strokeWidth);
        strokeWidthVisual.setStartX(0);
        strokeWidthVisual.setEndX(NODE_GAP*3);

        Button penOnOff = new Button("Toggle");
        penOnOff.setOnAction(e -> myTurtles.get(turtleIndex).setVisible(!myTurtles.get(turtleIndex).isVisible()));

        holder.getChildren().addAll(strokeWidthText, decreaseStrokeButton, increaseStrokeButton, strokeWidthVisual, penOnOff);
        holder.setAlignment(Pos.CENTER);
        return holder;
    }

    private void createMovementButtons (VBox holder) {
        GridPane buttonGrid = new GridPane();

        Button fd = new Button("FD");
        myTextElements.add(new TextElementButton(fd, "FD"));
        addTimer(fd, "fd 1");
        buttonGrid.add(fd, 0, 0);

        Button bk = new Button("BK");
        myTextElements.add(new TextElementButton(bk, "BK"));
        addTimer(bk, "bk 1");
        buttonGrid.add(bk, 1, 0);

        Button rt = new Button("RT");
        myTextElements.add(new TextElementButton(rt, "RT"));
        addTimer(rt, "rt 1");
        buttonGrid.add(rt, 0, 1);

        Button lt = new Button("LT");
        myTextElements.add(new TextElementButton(lt, "LT"));
        addTimer(lt, "lt 1");
        buttonGrid.add(lt, 1, 1);

        holder.getChildren().add(buttonGrid);
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

    private Node createTopBar() {
        HBox holder = new HBox(NODE_GAP);
        Pane holderPane = new Pane(holder);
        holder.prefWidthProperty().bind(holderPane.widthProperty());

        Text title = new Text(TITLE_TEXT);
        title.setId("title-text");

        Button resetButton = createButton("RESET", event -> { myStage.close(); start(); });
        myTextElements.add(new TextElementButton(resetButton, "RESET"));
        HBox.setHgrow(resetButton, Priority.ALWAYS);

        Button replayButton = createButton("REPLAY", event -> { myTransitionQueue = myLastExecuted; });
        myTextElements.add(new TextElementButton(replayButton, "REPLAY"));
        HBox.setHgrow(replayButton, Priority.ALWAYS);

        Button helpButton = createButton("HELP", event -> { helpButton(); });
        myTextElements.add(new TextElementButton(helpButton, "HELP"));
        HBox.setHgrow(helpButton, Priority.ALWAYS);

        Button turtleImageButton = createButton("NEW TURTLE IMAGE", event -> turtleImageButton());
        myTextElements.add(new TextElementButton(turtleImageButton, "NEW_TURTLE_IMAGE"));
        HBox.setHgrow(turtleImageButton, Priority.ALWAYS);

        Button saveFileButton = createButton("SAVE", event-> saveFileButtonClicked(userInputTextArea.getText()));
        HBox.setHgrow(saveFileButton,Priority.ALWAYS);
        //Button loadFileButton = createButton("SAVE", event-> loadFileButtonClicked());
        //HBox.setHgrow(saveFileButton,Priority.ALWAYS);
        
        initializeLanguageBox();
        Button loadFileButton = createButton("LOAD", event-> loadFileButtonClicked());
        HBox.setHgrow(saveFileButton,Priority.ALWAYS);

        initializeLanguageBox();
        HBox.setHgrow(myLanguageBox, Priority.ALWAYS);


        holder.getChildren().addAll(title, resetButton, replayButton, helpButton, turtleImageButton,saveFileButton, loadFileButton,
            myLanguageBox);
        return holderPane;
    }

    private HBox createColorButtons() {
        HBox cb = new HBox(NODE_GAP);
        Button envColor = createButton(BACKGROUND_COLOR, event -> envColorButton());
        myTextElements.add(new TextElementButton(envColor, BACKGROUND_COLOR));
        Button penColor = createButton(PEN_COLOR, event -> penColorButton());
        myTextElements.add(new TextElementButton(penColor, PEN_COLOR));
        cb.getChildren().addAll(envColor, penColor);
        return cb;
    }

    private void helpButton() {
        // TODO: create the help page
        HelpPage popup = new HelpPage();
    }

    private Rectangle createField(int x, int y, int width, int height) {
        Rectangle fld = new Rectangle(x, y, width, height);
        fld.setFill(Color.color(1.0, 1.0, 1.0));
        return fld;
    }

    private Shape createBackground(int x, int y, int width, int height, int border) {
      Shape bg = new Rectangle(x - border/2, y - border/2,
          width + border, height + border);
      bg.setId("turtle-UI");
      return bg;
    }

    private void initializeLanguageBox() {
        myLanguageBox = new ComboBox();
        myLanguageBox.setPromptText("SELECT LANGUAGE: ");
        myLanguageBox.setOnAction(e -> languageBox());

        List<String> languages = generateLanguages();
        setLanguageOptions(languages);
    }

    private List<String> generateLanguages() {
        languageTagMap = new HashMap<>();
        List<String> languages = new ArrayList<>();
        String rootDirectory = "src/parserModel/languages/commands"; // ***
        File[] files = new File(rootDirectory).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String filename = file.getName();
                String language = filename.replace(".properties", "");
                languages.add(language);
                ResourceBundle rb = ResourceBundle.getBundle
                    (String.format("%s%s", "parserModel.languages.commands.", language)); // ***
                String tag = rb.getString("languageTag");
                languageTagMap.put(language, tag);
            }
        }
        return languages;
    }

    public void setLanguageOptions(Collection<String> options) {
        myLanguageBox.getItems().clear();
        myLanguageBox.getItems().addAll(options);
    }

    private Button createButton(String text, EventHandler<ActionEvent> onClicked) {
        Button myButton = new Button();
        myButton.setMaxWidth(Double.MAX_VALUE);
        myButton.setText(text);
        myButton.setOnAction(onClicked);
        return myButton;
    }

    private ScrollPane createScrollPane(Node text, ScrollPane.ScrollBarPolicy hbar,
        ScrollPane.ScrollBarPolicy vbar, int width, int height) {

        ScrollPane sp = new ScrollPane(text);
        sp.setHbarPolicy(hbar);
        sp.setVbarPolicy(vbar);
        // sp.setMinHeight(0);
        return sp;
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

    private void saveFileButtonClicked(String text){
        FileChooser fileToSave = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileToSave.getExtensionFilters().add(extFilter);
        File file = fileToSave.showSaveDialog(myStage);
        if (file != null) {
            saveTextToFile(text, file);
        }
    }

    private void saveTextToFile(String textToSave, File fileToSave){
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(fileToSave);
            fileWriter.write(textToSave);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFileButtonClicked(){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open Resource File");
        File fileToLoad = fileChooser.showOpenDialog(myStage);
        try {
            Scanner scanned = new Scanner(fileToLoad);
            scanned.useDelimiter("\\Z");
            userInputTextArea.setText(scanned.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void changeLineStrokeWidth(double incrementSize){
        strokeWidth.set(strokeWidth.doubleValue() + incrementSize);
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

    /**
     * Private Animation methods
     * @author Mariusz
     */

    private Animation getSinglePositionTransition(int id, double startX, double startY, double endX, double endY) {
        SequentialTransition ret = new SequentialTransition();

        Turtle currentTurtle = fetchTurtle(id);
        double length = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
        int segments = length >= 10 ? (int) (length / 10) : 1;
        double lengthPerSegment = length / segments;
        double time = lengthPerSegment / TURTLE_SPEED_FPS;

        for (int i = 0; i < segments; i++) {
            Point2D.Double start = new Point2D.Double(startX, startY);
            Point2D.Double end = new Point2D.Double(endX, endY);
            PathTransition emptyTransition = getLocalTransition(start, end, currentTurtle, segments, time, i);
            ret.getChildren().add(emptyTransition);
        }
        return ret;
    }

    private PathTransition getLocalTransition(Point2D.Double startPoint, Point2D.Double endPoint, Turtle currentTurlte, int segments, double time, int i) {
        double dX = endPoint.x - startPoint.x;
        double dY = endPoint.y - startPoint.y;
        double adjustStartX, adjustStartY;
        double tempStartX = startPoint.x + (i / ((double) (segments))) * dX;
        double tempStartY = startPoint.y + (i / ((double) (segments))) * dY;
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

        Line line = getLine(adjustStartX, adjustStartY, adjustEndX, adjustEndY);
        Line displayLine = getDisplayLine(adjustStartX, adjustStartY, adjustEndX, adjustEndY);
        PathTransition emptyTransition = new PathTransition();
        emptyTransition.setDuration(Duration.seconds(time));
        emptyTransition.setOnFinished(event -> {
            displayLine.strokeWidthProperty().unbind();
            displayLine.setOpacity(1.0);
        });
        emptyTransition.setNode(currentTurlte);
        emptyTransition.setPath(line);
        return emptyTransition;
    }

    private Line getDisplayLine(double adjustStartX, double adjustStartY, double adjustEndX, double adjustEndY) {
        Line displayLine = getLine(adjustStartX, adjustStartY, adjustEndX, adjustEndY);
        displayLine.strokeWidthProperty().bind(strokeWidth);
        trailsGroup.getChildren().add(displayLine);
        displayLine.setOpacity(0.0);
        displayLine.layoutXProperty().bind(Bindings.divide(myParserPane.widthProperty(), 2.0));
        displayLine.layoutYProperty().bind(Bindings.divide(myParserPane.heightProperty(), 2.0));
        return displayLine;
    }

    private Line getLine(double adjustStartX, double adjustStartY, double adjustEndX, double adjustEndY) {
        Line line = new Line();
        line.setStartX(adjustStartX);
        line.setStartY(adjustStartY);
        line.setEndX(adjustEndX);
        line.setEndY(adjustEndY);
        return line;
    }

    private Turtle fetchTurtle(int id) {
        if (myTurtles.containsKey(id)) {
            return myTurtles.get(id);
        }
        Turtle initialTurtle = createTurtle(TURTLE_IMAGE, turtleIndex);
        parserField.getChildren().add(initialTurtle);
        initialTurtle.setTranslateX(-TURTLE_IMAGE_CENTER); //FIXME
        initialTurtle.setTranslateY(-TURTLE_IMAGE_CENTER);
        myTurtles.put(id, initialTurtle);
        return initialTurtle;
    }
    public double getLeadTurtleIndex () {
        return leadTurtleIndex;
    }
}