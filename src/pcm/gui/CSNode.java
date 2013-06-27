package pcm.gui;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class CSNode extends Circle {
    CSNode prev, next;
    boolean locked = false;
    
    public CSNode(CSNode prev, CSNode next) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CSNode.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        this.prev = prev;
        this.next = next;
        
        try{
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (locked) return;
                layoutXProperty().set(Math.min(Math.max(layoutXProperty().doubleValue() + me.getX(), 0.0), 200.0));
                layoutYProperty().set(Math.min(Math.max(layoutYProperty().doubleValue() + me.getY(), 0.0), 200.0));
            }
        });
    }
}