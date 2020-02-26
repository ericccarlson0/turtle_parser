package visualizer;


import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VariablePage {
    private ScrollPane variablePane;
    private Stage myStage;
    private Scene myScene;
    private ListView myListView;
    public VariablePage(ObservableList<String> variableList){
        myListView = new ListView(variableList);
        myStage = new Stage();
        Group myGroup = new Group();
        myGroup.getChildren().add(getPane());
        myScene = new Scene(myGroup);
        myStage.setScene(myScene);
        myStage.show();
    }

    private ScrollPane getPane() {
        variablePane = new ScrollPane(myListView);
        variablePane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        variablePane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        variablePane.setFitToHeight(true);
        variablePane.setFitToWidth(true);
        variablePane.setPrefSize(500, 500);
        return variablePane;
    }


}
