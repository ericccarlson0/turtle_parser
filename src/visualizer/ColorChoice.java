package visualizer;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ColorChoice extends VBox {
  public static final int DEFAULT_SPACING = 6;
  private static final int FIELD_LENGTH = 36;
  private static final String ZERO = "0";

  private VBox myVBox;
  private TextField RField;
  private TextField GField;
  private TextField BField;

  public ColorChoice () {
    myVBox = new VBox(DEFAULT_SPACING);

    Label RLabel = new Label("R");
    RLabel.setId("R-label");
    RField = createField();

    Label GLabel = new Label("G");
    GLabel.setId("G-label");
    GField = createField();

    Label BLabel = new Label("B");
    BLabel.setId("B-label");
    BField = createField();

    myVBox.getChildren().addAll(RLabel, RField, GLabel, GField, BLabel, BField);
  }

  private TextField createField() {
    TextField field = new TextField();
    field.setText(ZERO);
    field.setId("color-field");
    return field;
  }

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
    String colorStr = colorField.getText(0, 3);
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
