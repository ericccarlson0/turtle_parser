package visualizer;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Page {
    private static final int PANE_SIZE = 250;
    private ScrollPane textPane;
    private ListView myListView;
    public Page(){
        myListView = new ListView();
        initiate();
    }

    public ScrollPane getScrollPane(){
        return textPane;
    }

    public void setList(ObservableList list){
        myListView.setItems(list);
    }

    private void initiate(){
        Group myGroup = new Group();
        setScrollPane();
        myGroup.getChildren().add(textPane);
    }

    private void setScrollPane() {
        textPane = new ScrollPane(myListView);
        textPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        textPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        textPane.setFitToHeight(true);
        textPane.setFitToWidth(true);
        VBox.setVgrow(textPane, Priority.ALWAYS);
        textPane.setMinHeight(0);
    }
}
