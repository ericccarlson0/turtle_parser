package visualizer;

import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

public class Page {
    private static final int PANE_SIZE = 250;
    private ScrollPane textPane;
    private ObservableList myListView;
    public Page(ObservableList list){
        myListView = list;
        initiate();
    }

    public ScrollPane getScrollPane(){
        return textPane;
    }

    public void setList(ObservableList list){
        myListView = list;
    }

    private void initiate(){
        //myStage = new Stage();
        Group myGroup = new Group();
        setScrollPane();
        myGroup.getChildren().add(textPane);

        //myScene = new Scene(myGroup);
        //myStage.setScene(myScene);
        //myStage.show();
    }

    private void setScrollPane() {
        textPane = new ScrollPane();
        textPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        textPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        textPane.setFitToHeight(true);
        textPane.setFitToWidth(true);
        textPane.setPrefSize(PANE_SIZE, PANE_SIZE);
    }


}
