package visualizer;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Field {
    Rectangle field;
    public Field(int x, int y, int width, int height){
        field = new Rectangle(x, y, width, height);
        field.setFill(Color.WHITE);
    }
}
