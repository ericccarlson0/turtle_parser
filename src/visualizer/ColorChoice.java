package visualizer;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class ColorChoice {
  public static final int DEFAULT_SPACING = 6;
  private static final int FIELD_LENGTH = 36;
  private static final String ZERO = "0";

  private HBox myHBox;
  private TextField RField;
  private TextField GField;
  private TextField BField;
//  private int myR;
//  private int myG;
//  private int myB;

  public ColorChoice (String title, int R, int G, int B) {
    myHBox = new HBox(DEFAULT_SPACING);

    Label titleLabel = new Label(title);

    Label RLabel = new Label("R");
    RLabel.setId("R-label");
    RField = createField(R);

    Label GLabel = new Label("G");
    GLabel.setId("G-label");
    GField = createField(G);

    Label BLabel = new Label("B");
    BLabel.setId("B-label");
    BField = createField(B);

    myHBox.getChildren().addAll(titleLabel, RLabel, RField, GLabel, GField, BLabel, BField);
  }

  private TextField createField(int val) {
    TextField field = new TextField();
    field.setText(Integer.toString(val));
    field.setId("color-field");
    return field;
  }

  public Region getVisual() { return myHBox; }

  public int getR() {
    return textToRGB(RField);
  }
  public int getG() {
    return textToRGB(GField);
  }
  public int getB() {
    return textToRGB(BField);
  }

  private int textToRGB(TextField colorField) {
    String colorStr = colorField.getText();
    int colorInt = Integer.parseInt(colorStr);
    if (colorInt > 255) {
      colorInt = 255;
    } else if (colorInt < 0) {
      colorInt = 0;
    }
    colorField.setText(Integer.toString(colorInt));
    return colorInt;
  }
}
