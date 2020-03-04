package visualizer.languageSensitive;

import javafx.scene.control.Button;

public class TextElementButton extends TextElement {
  Button myNode;

  public TextElementButton(Button button, String text) {
    super(button, text);
    myNode = button;
    changeLanguage(DEFAULT_LANGUAGE);
  }

  protected void putText(String newText) {
    myNode.setText(newText);
  }
}
