package testing;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.scene.text.Text;

public class TextElement {
  public static final String RESOURCE_BUNDLE = "TextElements";

  private Text myNode;
  private String myString;

  public TextElement(Text node, String str) {
    myNode = node;
    myString = str.toUpperCase();
    myNode.setText(myString);
  }

  public void changeLanguage(String language) {
    Locale locale = new Locale(language);
    ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_BUNDLE, locale);
    String newstr = bundle.getString(myString).toUpperCase();
    myNode.setText(newstr);
  }
}
