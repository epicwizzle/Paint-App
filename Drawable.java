import javafx.scene.canvas.GraphicsContext;

/**
 * This interface represents a drawable object.
 * It has a draw method that takes in a GraphicsContext object and draws the object.
 *
 * @author Esenwa Michael 000876059
 * Date: February 20, 2023
 */
public interface Drawable {
    //TODO: Add methods

    /**
     * This method used to draw the object.
     *
     * @param gc the GraphicsContext object
     */
    public abstract void  draw(GraphicsContext gc);
}
