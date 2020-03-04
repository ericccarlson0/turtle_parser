package visualizer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ResourceBundle;

public class HelpPage {
    private final String language = ResourceBundle.getBundle("languages.LanguageChoice").getString("Language");
    private final ResourceBundle commands = ResourceBundle.getBundle("parserModel.languages."+language);
    private static final int SCREEN_SIZE = 500;

    public HelpPage() {
        Stage myStage = new Stage();
        Group myGroup = new Group();
        myGroup.getChildren().add(createPane());
        Scene myScene = new Scene(myGroup);
        myStage.setScene(myScene);
        myStage.show();
    }

    private ScrollPane createPane() {
        Text helpText = new Text();
        String currText = "POSSIBLE COMMANDS: ";
        for (String key : commands.keySet()){
            currText = String.format("%s%s%s%s%s", "\n", key, " : ", commands.getString(key));
        }
        helpText.setText(currText);
        ScrollPane helpPane = new ScrollPane(helpText);
        helpPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        helpPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        helpPane.setFitToHeight(true);
        helpPane.setFitToWidth(true);
        helpPane.setPrefSize(SCREEN_SIZE, SCREEN_SIZE);
        return helpPane;
    }
}
