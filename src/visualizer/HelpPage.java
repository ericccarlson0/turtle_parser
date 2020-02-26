package visualizer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelpPage {
    private final String language = ResourceBundle.getBundle("languages."+"LanguageChoice").getString("Language");
    private final ResourceBundle commands = ResourceBundle.getBundle("parserModel.languages."+language);
    private ScrollPane helpPane;
    private Text helpText;
    private Stage myStage;
    private Scene myScene;
    public HelpPage(){
        myStage = new Stage();
        Group myGroup = new Group();
        myGroup.getChildren().add(getPane());
        myScene = new Scene(myGroup);
        myStage.setScene(myScene);
        myStage.show();

    }

    private ScrollPane getPane() {
        helpText = new Text("Possible Commands");
        for(String key:commands.keySet()){
            helpText.setText(helpText.getText() + "\n" + key + " = " + commands.getString(key));
        }
        helpPane = new ScrollPane(helpText);
        helpPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        helpPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        helpPane.setFitToHeight(true);
        helpPane.setFitToWidth(true);
        helpPane.setPrefSize(500, 500);
        return helpPane;
    }


}
