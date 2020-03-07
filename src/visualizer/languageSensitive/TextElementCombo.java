package visualizer.languageSensitive;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;

public class TextElementCombo extends TextElement {
  ComboBox myNode;

  public TextElementCombo(ComboBox node, String text) {
    super(node, text);
    myNode = node;
    changeLanguage(defaultLocale);
  }

  protected void putText(String newText) {
    myNode.setPromptText(newText);
  }
}
