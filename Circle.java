import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Circle.java
 * This class represents a circle.
 * It has an x and y coordinate, a fill color, and a radius.
 * It has a constructor that takes in an x, y, color, and radius.
 * It has getX, getY, getFillColor, and getRadius methods.
 * It implements the Drawable interface.
 *
 * @author Esenwa Michael 000876059
 * Date: February 20, 2023
 */
public class Circle extends GeometricObject {
    //TODO: Add instance variables
    private double radius; // radius of the circle

    /**
     * This is the constructor for the Circle class.
     * It takes in an x, y, color, and radius.
     * It sets the x, y, fillColor, and radius instance variables.
     *
     * @param x         the x coordinate of the circle
     * @param y         the y coordinate of the circle
     * @param fillColor the fill color of the circle
     * @param radius    the radius of the circle
     */
    public Circle(double x, double y, Color fillColor, double radius) {
        super(x, y, fillColor);
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero");
        } else {
            this.radius = radius;
        }
    }
    //TODO: Add methods

    /**
     * This method used draw the circle.
     *
     * @param gc the GraphicsContext object
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillOval(getX(), getY(), radius, radius);
    }

}
