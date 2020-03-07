package visualizer.languageSensitive;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.scene.text.Text;

public class TextElementCommand extends TextElement {
  public static final String COMMAND_DIRECTORY = "commands.";
  Text myNode;

  public TextElementCommand(Text textControl, String text) {
    super(textControl, text);
    myNode = textControl;
    // changeLanguage(defaultLocale);
  }

  @Override
  public void changeLanguage(Locale locale) {
    String bundleDir = String.format("%s%s", COMMAND_DIRECTORY, locale.getDisplayLanguage());
    ResourceBundle bundle = ResourceBundle.getBundle(bundleDir);
    String[] tokenArray = myString.split(" ");

    String newText = "";
    for (String token: tokenArray) {
      if (token.matches("^[a-zA-Z]*$")) {
        token = bundle.getString(token); // Should return, for instance, forward|fd.
      }
      newText = String.format("%s %s", newText, token);
      // System.out.println(newText);
    }
    putText(newText.substring(1));
  }

  protected void putText(String newText) {
    myNode.setText(newText);
  }
}
