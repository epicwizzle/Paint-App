import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Square {


    public Rectangle(double x, double y, Color fillColor, double size) {
        super(x, y, fillColor, size);

    }

    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillRect(getX(), getY(), getSize(), getSize() / 2);
    }
}
