import javafx.scene.paint.Color;

/**
 * GeometricObject.java
 * This class represents a geometric object.
 * It has an x and y coordinate and a fill color.
 * It has a constructor that takes in an x, y, and color.
 * It has getX, getY, and getFillColor methods.
 * It implements the Drawable interface.
 *
 * @author Esenwa Michael 000876059
 * Date: February 20, 2023
 */
public abstract class GeometricObject implements Drawable {
    //TODO: Add instance variables
    private double x; // x coordinate of the geometric object
    private double y; // y coordinate of the geometric object
    private Color fillColor; // fill color of the geometric object


    /**
     * This is the constructor for the GeometricObject class.
     * It takes in an x, y, and color.
     * It sets the x, y, and fillColor instance variables.
     *
     * @param x         the x coordinate of the geometric object
     * @param y         the y coordinate of the geometric object
     * @param fillColor the fill color of the geometric object
     */
    public GeometricObject(double x, double y, Color fillColor) {
        if (x <= 0 || x >= 800) {
            throw new IllegalArgumentException("X must be between 1 and 799");
        } else {
            this.x = x;
        }
        if (y <= 0 || y >= 390) {
            throw new IllegalArgumentException("Y must be between 1 and 389");
        } else {
            this.y = y;
        }
        this.fillColor = fillColor;
    }
    //TODO: Add methods

    /**
     * This method used to get the x coordinate of the geometric object.
     *
     * @return the x coordinate of the geometric object
     */
    public double getX() {
        return x;
    }

    /**
     * This method used to get the y coordinate of the geometric object.
     *
     * @return the y coordinate of the geometric object
     */
    public double getY() {
        return y;
    }

    /**
     * This method used to get the fill color of the geometric object.
     *
     * @return the fill color of the geometric object
     */
    public Color getFillColor() {
        return fillColor;
    }
}


