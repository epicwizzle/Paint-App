
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.ArrayList;


/**
 * This class represents a paint application.
 * It is a JavaFX application that allows the user to draw circles, rectangles and squares.
 * @author Esenwa Michael 000876059
 * Date: February 20, 2023
 */
public class PaintApp extends Application {

    // TODO: Instance Variables for View Components and Model
    private ArrayList<GeometricObject> shapes; // list of shapes
    private GraphicsContext bottom, top; // graphics context for the bottom and top canvas
    private TextField xField, yField, sizeField, rField, gField, bField; // text fields for the x, y, size, and color values
    private ChoiceBox<String> shapeChoice; // choice box for the shape
    private Label messageLabel; // label for error messages



    // TODO: Private Event Handlers and Helper Methods
    /**
     * This method is called when the user clicks the draw button.
     * It draws the shape on the bottom canvas.
     * @param e the ActionEvent object
     */
    private void draw(ActionEvent e) {
        double x = Double.parseDouble(xField.getText());
        double y = Double.parseDouble(yField.getText());
        messageLabel.setTextFill(Color.GREEN);
        if (shapeChoice.getValue().equals("Circle")) {
            try {
                double radius = Double.parseDouble(sizeField.getText());
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                Circle circle = new Circle(x, y, Color.rgb(r, g, b), radius);
                shapes.add(circle);
                circle.draw(bottom);
                messageLabel.setText("Circle Drawn");
            } catch (IllegalArgumentException ex) {
                messageLabel.setText("Error: " + ex.getMessage());
                messageLabel.setTextFill(Color.RED);
            }
        }
        if (shapeChoice.getValue().equals("Square")) {
            try {
                double size = Double.parseDouble(sizeField.getText());
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                Square square = new Square(x, y, Color.rgb(r, g, b), size);
                shapes.add(square);
                square.draw(bottom);
                messageLabel.setText("Square Drawn");
            } catch (IllegalArgumentException ex) {
                messageLabel.setText("Error: " + ex.getMessage());
                messageLabel.setTextFill(Color.RED);
            }
        }
        if (shapeChoice.getValue().equals("Rectangle")) {
            try {
                double size = Double.parseDouble(sizeField.getText());
                int r = Integer.parseInt(rField.getText());
                int g = Integer.parseInt(gField.getText());
                int b = Integer.parseInt(bField.getText());
                Rectangle rectangle = new Rectangle(x, y, Color.rgb(r, g, b), size);
                shapes.add(rectangle);
                rectangle.draw(bottom);
                messageLabel.setText("Rectangle Drawn");
            } catch (IllegalArgumentException ex) {
                messageLabel.setText("Error: " + ex.getMessage());
                messageLabel.setTextFill(Color.RED);
            }
        }
    }
    /**
     * This method is called when the user clicks the canvas.
     * It draws the shape on the canvas.
     * @param me the MouseEvent object
     */
    private void mouseClicked(MouseEvent me) {
        mouse(me);
    }
    /**
     * This method is called when the user drags the mouse.
     * @param me the MouseEvent object
     */
    private void mouseDragged(MouseEvent me) {
        mouse(me);
    }

    /**
     * This method is called when the user moves the mouse.
     * @param me the MouseEvent object
     */
    private void mouseMoved(MouseEvent me) {
        top.clearRect(0, 0, 800, 390);
        top.setFill(Color.RED);
        top.fillOval(me.getX()-5, me.getY()-5, 10, 10);
    }
    /**
     * This method is used during mouse events.
     * @param me the MouseEvent object
     */
    private void mouse(MouseEvent me) {
        int r = Integer.parseInt(rField.getText());
        int g = Integer.parseInt(gField.getText());
        int b = Integer.parseInt(bField.getText());
        if (shapeChoice.getValue().equals("Circle")) {
            try {
                double radius = Double.parseDouble(sizeField.getText());
                Circle circle = new Circle(me.getX()-radius/2, me.getY()-radius/2, Color.rgb(r, g, b), radius);
                shapes.add(circle);
                circle.draw(bottom);
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Circle Drawn");
            } catch (IllegalArgumentException ex) {
                messageLabel.setText("Error: " + ex.getMessage());
                messageLabel.setTextFill(Color.RED);
            }

        }
        if (shapeChoice.getValue().equals("Square")) {
            try {
                double size = Double.parseDouble(sizeField.getText());
                Square square = new Square(me.getX()-size/2, me.getY()-size/2, Color.rgb(r, g, b), size);
                shapes.add(square);
                square.draw(bottom);
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Square Drawn");
            } catch (IllegalArgumentException ex) {
                messageLabel.setText("Error: " + ex.getMessage());
                messageLabel.setTextFill(Color.RED);
            }

        }
        if (shapeChoice.getValue().equals("Rectangle")) {
            try {
                double size = Double.parseDouble(sizeField.getText());
                Rectangle rectangle = new Rectangle(me.getX()-size/2, me.getY()-size/2, Color.rgb(r, g, b), size);
                shapes.add(rectangle);
                rectangle.draw(bottom);
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Rectangle Drawn");
            } catch (IllegalArgumentException ex) {
                messageLabel.setText("Error: " + ex.getMessage());
                messageLabel.setTextFill(Color.RED);
            }
        }
    }
    /**
     * This method is called when the user clicks the UnDraw button.
     * It removes the last shape drawn.
     * @param e the ActionEvent object
     */
    private void unDraw(ActionEvent e) {
        if (shapes.size() > 0) {
            shapes.remove(shapes.size() - 1);
            bottom.setFill(Color.GRAY);
            bottom.fillRect(0, 0, 800, 390);
            for (GeometricObject shape : shapes) {
                shape.draw(bottom);
            }
            messageLabel.setTextFill(Color.GREEN);
            messageLabel.setText("Shape has been removed");


        } else {
            messageLabel.setText("No shapes to remove");
            messageLabel.setTextFill(Color.RED);

        }

    }
    /**
     * This method is called when the user clicks the clear button.
     * It removes all shapes drawn.
     * @param e the ActionEvent object
     */
    private void clear(ActionEvent e) {
        shapes.clear();
        bottom.setFill(Color.GRAY);
        bottom.fillRect(0, 0, 800, 390);
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText("Cleared");

    }



    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 480); // set the size here
        stage.setTitle("Assignment 8"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        shapes = new ArrayList<>();


        Canvas topCanvas = new Canvas(800, 390);
        Canvas bottomCanvas = new Canvas(800, 390);
        // 2. Create the GUI components
        top = topCanvas.getGraphicsContext2D();
        top.clearRect(0, 0, 800, 390);

        bottom = bottomCanvas.getGraphicsContext2D();
        bottom.setFill(Color.GRAY);
        bottom.fillRect(0, 0, 800, 390);

        Label label = new Label("Press Draw or Click Canvas for a Circle");
        String[] buttonNames = {"Circle", "Square", "Rectangle"};
        shapeChoice = new ChoiceBox<>(FXCollections.observableArrayList(buttonNames));
        shapeChoice.setValue("Circle");

        Label locationLabel = new Label("Location: ");
        xField = new TextField("400");
        yField = new TextField("200");

        Label sizeLabel = new Label("Size: ");
        sizeField = new TextField("10");

        Label colorLabel = new Label("Color: ");
        rField = new TextField("255");
        gField = new TextField("128");
        bField = new TextField("0");

        Button drawButton = new Button("Draw");
        Button undrawButton = new Button("UnDraw");
        Button clearButton = new Button("Clear");

        messageLabel = new Label();
        // 3. Add components to the root
        root.getChildren().addAll(label, bottomCanvas, topCanvas,  shapeChoice, locationLabel, xField, yField, sizeLabel, sizeField, colorLabel, rField, gField, bField, drawButton, undrawButton, messageLabel, clearButton);
        // 4. Configure the components (colors, fonts, size, location)
        label.relocate(0, 0);
        label.setPrefWidth(800);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Arial", 20));
        label.setStyle("-fx-background-color: Cyan; -fx-text-fill: black;");

        topCanvas.relocate(0, 25);


        bottomCanvas.relocate(0, 25);

        shapeChoice.relocate(0, 420);
        shapeChoice.setPrefWidth(100);
        shapeChoice.setPadding(new Insets(0, 0, 0, 20));


        locationLabel.relocate(120, 420);

        xField.relocate(170, 420);
        xField.setPrefWidth(50);
        xField.setAlignment(Pos.CENTER);

        yField.relocate(220, 420);
        yField.setPrefWidth(50);
        yField.setAlignment(Pos.CENTER);

        sizeLabel.relocate(310, 420);
        sizeField.relocate(340, 420);
        sizeField.setPrefWidth(50);
        sizeField.setAlignment(Pos.CENTER);

        colorLabel.relocate(410, 420);
        rField.relocate(450, 420);
        rField.setPrefWidth(50);
        rField.setAlignment(Pos.CENTER);

        gField.relocate(500, 420);
        gField.setPrefWidth(50);
        gField.setAlignment(Pos.CENTER);

        bField.relocate(550, 420);
        bField.setPrefWidth(50);
        bField.setAlignment(Pos.CENTER);

        drawButton.relocate(620, 420);
        undrawButton.relocate(665, 420);
        clearButton.relocate(725, 420);

        messageLabel.relocate(0, 450);
        messageLabel.setPrefWidth(800);
        messageLabel.setAlignment(Pos.CENTER);
        messageLabel.setStyle("-fx-background-color: Cyan;");
        messageLabel.setFont(new Font("Arial", 20));


        // 5. Add Event Handlers and do final setup
        drawButton.setOnAction(this::draw);
        undrawButton.setOnAction(this::unDraw);
        clearButton.setOnAction(this::clear);
        topCanvas.setOnMouseDragged(this::mouseDragged);
        topCanvas.setOnMouseClicked(this::mouseClicked);
        topCanvas.setOnMouseMoved(this::mouseMoved);




        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
