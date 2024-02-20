import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Square.java
 * This class represents a square.
 * It has an x and y coordinate, a fill color, and a size.
 * It has a constructor that takes in an x, y, color, and size.
 * It has getX, getY, getFillColor, and getSize methods.
 * It implements the Drawable interface.
 *
 * @author Esenwa Michael 000876059
 * Date: February 20, 2023
 */
public class Square extends GeometricObject {
    //TODO: Add instance variables
    private double size; // size of the square

    /**
     * This is the constructor for the Square class.
     * It takes in an x, y, color, and size.
     * It sets the x, y, fillColor, and size instance variables.
     *
     * @param x         the x coordinate of the square
     * @param y         the y coordinate of the square
     * @param fillColor the fill color of the square
     * @param size      the size of the square
     */

    public Square(double x, double y, Color fillColor, double size) {
        super(x, y, fillColor);
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero");
        } else {
            this.size = size;
        }

    }
    //TODO: Add methods

    /**
     * This method used to draw the square.
     *
     * @param gc the GraphicsContext object
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillRect(getX(), getY(), size, size);
    }

    /**
     * This method used to get the size of the square.
     *
     * @return the size of the square
     */
    public double getSize() {
        return size;
    }
}
