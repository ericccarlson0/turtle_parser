package visualizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ResourceBundle;
import visualizer.languageSensitive.TextElement;
import visualizer.languageSensitive.TextElementText;

public class HelpPage {

    private ResourceBundle bundleOfCommands;
    private Scanner bundleScanner;
    public static final String COMMAND_DIRECTORY = "commands.";
    public static final String FULL_COMMAND_DIRECTORY = "./resources/commands/";
    public static final String POSSIBLE_COMMANDS = "POSSIBLE_COMMANDS";
    public static final int SCREEN_SIZE = 500;

    private List<TextElement> textElements;
    private VBox helpBox;

    public HelpPage(Locale locale) throws FileNotFoundException {
        String language = locale.getDisplayLanguage();
//        bundleOfCommands = ResourceBundle.getBundle(String.format("%s%s",
//            COMMAND_DIRECTORY, language));
        File commandFile = new File(String.format("%s%s%s",
            FULL_COMMAND_DIRECTORY, language, ".properties"));
        bundleScanner = new Scanner(commandFile);

        Stage stage = new Stage();
        Group group = new Group();
        group.getChildren().add(createPane());
        Scene scene = new Scene(group);
        stage.setScene(scene);
        String stylesheet = String.format("%s%s", Visualizer.RESOURCE_FOLDER, Visualizer.STYLESHEET);
        scene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
        stage.show();
    }

    private void addTextElement(String text) {
        Text node = new Text(text);
        helpBox.getChildren().add(node);
        textElements.add(new TextElementText(node, text));

    }

    private ScrollPane createPane() {
        textElements = new ArrayList<>();
        helpBox = new VBox(Visualizer.NODE_GAP);
//        addTextElement(POSSIBLE_COMMANDS); // Header.

        while (bundleScanner.hasNextLine()) {
            String line = bundleScanner.nextLine();
            int startIndex = line.indexOf('=') + 1;
            String commandText = line.substring(startIndex);
            helpBox.getChildren().add(new Text(commandText));
        }

//        for (String key : bundleOfCommands.keySet()) {
//            String command = bundleOfCommands.getString(key);
//            String text = String.format("%s%s%s", key, " : ", command);
//            helpBox.getChildren().add(new Text(text));
//        }

        ScrollPane helpPane = new ScrollPane(helpBox);
        helpPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        helpPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        helpPane.setFitToHeight(true);
        helpPane.setFitToWidth(true);
        helpPane.setPrefSize(SCREEN_SIZE, SCREEN_SIZE);
        return helpPane;
    }
}
