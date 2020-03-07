package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import visualizer.languageSensitive.TextElement;
import visualizer.languageSensitive.TextElementText;

public class PopupWindowTester {

  private static final String RESOURCE_FOLDER = "/stylesheets";
  private static final String STYLESHEET = "/default.css";

  private static final double TOTAL_WIDTH = 400;
  private static final double TOTAL_HEIGHT = 400;
  private static final double DEF_GAP = 12;
  private static final Paint BACKGROUND = Color.color(1.0, 1.0, 1.0);
  private static final String TITLE = "TESTING";
  public static final int DELAY = 10;
  private ComboBox myLanguageBox;
  private Stage myStage;
  private Scene myScene;
  private Group myRoot;
  private GridPane myGrid;
  private List<TextElement> myTextElements;
  private List<String> textList = Arrays.asList(new String[]{"start", "stop", "turtle", "pen"});

  public PopupWindowTester() {
    myStage = new Stage();
    setUpScene();
    myStage.setScene(myScene);
    myStage.show();
    start();
  }

  private void setUpScene() {
    myLanguageBox = createLanguageBox();
    setUpRoot();

    myScene = new Scene(myRoot, TOTAL_WIDTH, TOTAL_HEIGHT, BACKGROUND);
    String stylesheet = String.format("%s%s", RESOURCE_FOLDER, STYLESHEET);
    myScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
  }

  private void setUpRoot() {
    List<String> options = Arrays.asList(new String[]{"EN", "ES", "FR", "DE", "ZH", "JA"});
    setLanguageOptions(options);

    setUpGrid();
    myRoot = new Group();
    myRoot.getChildren().add(myGrid);
  }

  private void setUpGrid() {
    myGrid = new GridPane();
    Text title = new Text(TITLE);
    Node buttons = createButtons();
    myGrid.add(title, 0, 0);
    myGrid.add(buttons, 0, 1);
  }

  private Node createButtons() {
    HBox holder = new HBox(DEF_GAP);
    holder.getChildren().addAll(myLanguageBox, createTextElements());
    return holder;
  }

  private Node createTextElements() {
    VBox holder = new VBox(DEF_GAP);
    myTextElements = new ArrayList<>();
    for (String text: textList) {
      Text node = new Text(text);
      TextElement element = new TextElementText(node, text);
      myTextElements.add(element);
      holder.getChildren().add(node);
    }
    return holder;
  }

  private void start() {
    KeyFrame kf = new KeyFrame(Duration.millis(DELAY), e -> { step(); });
    Timeline tl = new Timeline();
    tl.setCycleCount(Timeline.INDEFINITE);
    tl.getKeyFrames().add(kf);
    tl.play();
  }

  private void step () {
    // *** test out language options
  }

  private ComboBox createLanguageBox() {
    ComboBox lb = new ComboBox();
    lb.setPromptText("LANGUAGE: ");
    lb.setOnAction(e -> languageBox());
    return lb;
  }

  // ***
  public void setLanguageOptions(Collection<String> options) {
    myLanguageBox.getItems().clear();
    myLanguageBox.getItems().addAll(options);
  }

  private void languageBox() {
  }

  public ObjectProperty<String> getLanguageProperty(){
    return myLanguageBox.valueProperty();
  }
}
