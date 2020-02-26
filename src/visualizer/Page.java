package visualizer;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Page {
    private static final int SCREEN_SIZE = 500;
    private ScrollPane textPane;
    private Stage myStage;
    private Scene myScene;
    private ListView myListView;
    public Page(ObservableList<String> variableList){
        myListView = new ListView(variableList);
        initiate();
    }

    private void initiate(){
        myStage = new Stage();
        Group myGroup = new Group();
        myGroup.getChildren().add(getPane(textPane));
        myScene = new Scene(myGroup);
        myStage.setScene(myScene);
        myStage.show();
    }

    private ScrollPane getPane(ScrollPane tempPane) {
        tempPane = new ScrollPane(myListView);
        tempPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        tempPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        tempPane.setFitToHeight(true);
        tempPane.setFitToWidth(true);
        tempPane.setPrefSize(SCREEN_SIZE, SCREEN_SIZE);
        return tempPane;
    }


}
