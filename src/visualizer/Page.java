package visualizer;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Page {
    private ScrollPane textPane;
    private ListView myListView;
    private TextArea myTextArea;
    private String myDescription;

    public Page(String x, TextArea text) {
        myTextArea = text;
        myDescription = x;
        myListView = new ListView();
        initiate();
    }

    private void initiate() {
        Group myGroup = new Group();
        setScrollPane();
        myGroup.getChildren().add(textPane);
    }

    private void setScrollPane() {
        textPane = new ScrollPane(myListView);
        myListView.setOnMouseClicked(e -> handleEdit());
        textPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        textPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        textPane.setFitToHeight(true);
        textPane.setFitToWidth(true);
        VBox.setVgrow(textPane, Priority.ALWAYS);
    }

    private void handleEdit() {
        String editText = "";
        for(Object x : myListView.getItems()){
            if(myDescription.equals("set")){
                editText = editText + myDescription + " " + x.toString() + " \n";
            }
            else if(myDescription.equals("to")){
                editText = editText + myDescription + " " + x.toString() + " \n";
            }
        }
        myTextArea.setText(editText);
    }

    public ScrollPane getScrollPane(){
        return textPane;
    }

    public void setList(ObservableList list){
        myListView.setItems(list);
    }
}
