package visualizer.languageSensitive;

import java.util.Locale;
import javafx.scene.text.Text;

public class TextElementText extends TextElement {
  Text myNode;

  public TextElementText(Text textControl, String text) {
    super(textControl, text);
    myNode = textControl;
    changeLanguage(defaultLocale);
  }

  protected void putText(String newText) {
    myNode.setText(newText);
  }
}
