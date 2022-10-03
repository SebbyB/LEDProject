package com.example.ledproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color ;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public void stuff(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        final TextField name = new TextField();

        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);


    }



    @Override
    public void start(Stage stage) throws IOException {

        LEDColor color = new LEDColor();
        Button addButton = new Button("Add to Color...");
        Button subtractButton = new Button("Subtract from Color...");
        Button multiplyButton = new Button("multiply Color by a factor of...");
        Button setButton = new Button("Set Color to...");

        String h = color.getHex();
        String r = Short.toString(color.getRed());
        String g = Short.toString(color.getGreen());
        String b = Short.toString(color.getBlue());

        Label hexVal = new Label(h);
        Label redVal = new Label(r);
        Label greenVal = new Label(g);
        Label blueVal = new Label(b);

        color.setColor("#abcdef");
        Color c = Color.web(color.getHex());



        Rectangle rectangle = new Rectangle(400, 40);
        rectangle.setFill(c);
        TextField colorField = new TextField ();
        colorField.setPromptText("Enter stuff...");
        colorField.setPrefColumnCount(7);


        setButton.setOnAction(value ->  {
            String text = colorField.getText();
            System.out.println("Setting Color to " + text + "...");
            color.setColor(text);
            rectangle.setFill(Color.web(color.getHex()));
            hexVal.setText(h);
            redVal.setText(r);
            greenVal.setText(g);
            blueVal.setText(b);
            color.printColors();

        });
        addButton.setOnAction(value ->  {
            String text = colorField.getText();
            System.out.println("Adding " + text + " to Color...");
            color.addColor(text);
            rectangle.setFill(Color.web(color.getHex()));
            hexVal.setText(h);
            redVal.setText(r);
            greenVal.setText(g);
            blueVal.setText(b);
            color.printColors();

        });

        subtractButton.setOnAction(value ->  {
            String text = colorField.getText();
            System.out.println("Subtracting " + text + " from Color...");
            color.subtractColor(text);
            rectangle.setFill(Color.web(color.getHex()));
            hexVal.setText(h);
            redVal.setText(r);
            greenVal.setText(g);
            blueVal.setText(b);

            color.printColors();

        });

        multiplyButton.setOnAction(value ->  {
            String text = colorField.getText();
            System.out.println("Multiplying Color by a factor of " + text + "...");
            color.multiplyColor(text);
            rectangle.setFill(Color.web(color.getHex()));
            hexVal.setText(h);
            redVal.setText(r);
            greenVal.setText(g);
            blueVal.setText(b);
            color.printColors();

        });

        HBox hbox = new HBox(hexVal,addButton, subtractButton,multiplyButton,setButton,redVal,greenVal,blueVal,colorField,rectangle);

        Scene scene = new Scene(hbox, 1920, 1080);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();

    }
}