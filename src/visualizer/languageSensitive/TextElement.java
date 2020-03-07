package visualizer.languageSensitive;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.scene.Node;

public abstract class TextElement {
  public static final String BUNDLE_DIRECTORY = "TextElements";
  public static final String DEFAULT_LANGUAGE = "ENGLISH";
  protected static final Locale defaultLocale = Locale.ENGLISH;

  private String myString;

  public TextElement(Node node, String text) {
    myString = text.toUpperCase();
  }

  public void changeLanguage(Locale locale) {
    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_DIRECTORY, locale);
    String newText = bundle.getString(myString);
    putText(newText);
  }

  protected String replaceUnderscores(String text) {
    StringBuilder builder = new StringBuilder();
    for (int i=0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '_') {
        builder.append(' ');
      } else {
        builder.append(c);
      }
    }
    return builder.toString();
  }

  protected abstract void putText(String newText);
}
