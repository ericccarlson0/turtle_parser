package visualizer.languageSensitive;

import javafx.scene.text.Text;

public class TextElementText extends TextElement {
  Text myNode;

  public TextElementText(Text textControl, String text) {
    super(textControl, text);
    myNode = textControl;
    changeLanguage(DEFAULT_LANGUAGE);
  }

  protected void putText(String newText) {
    myNode.setText(newText);
  }
}
