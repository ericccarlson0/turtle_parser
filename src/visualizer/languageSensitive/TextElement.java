package visualizer.languageSensitive;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Node;

public abstract class TextElement {
  public static final String BUNDLE_DIRECTORY = "TextElements";
  public static final String DEFAULT_LANGUAGE = "ENGLISH";

  public static final Map<String, String> LANGUAGE_CODES;
  static {
    Map<String, String> languageMap = new HashMap<String, String>();
    languageMap.put("ENGLISH", "EN");
    languageMap.put("SPANISH", "ES");
    languageMap.put("FRENCH", "FR");
    languageMap.put("GERMAN", "DE");
    languageMap.put("PORTUGUESE", "PT");
    languageMap.put("ITALIAN", "IT");
    languageMap.put("RUSSIAN", "RU");
    languageMap.put("CHINESE", "ZH");
    languageMap.put("JAPANESE", "JA");
    languageMap.put("URDU", "UR");

    LANGUAGE_CODES = Collections.unmodifiableMap(languageMap);
  }
  private String myString;

  public TextElement(Node node, String text) {
    myString = text.toUpperCase();
  }

  public void changeLanguage(String language) {
    language = language.toUpperCase();
    String languageCode = LANGUAGE_CODES.get(language);
    Locale locale = new Locale(languageCode);
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
