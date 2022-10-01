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




        Color color = new Color();
        color.setColor("#11ee11");
        String buttonColor = color.getHex();
        Button button = new Button("Click me!");

        Label label = new Label("Not clicked");

        button.setOnAction(value ->  {
            label.setText("Clicked!");
        });
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);

        button.setFont(font);
        button.setStyle("-fx-background-color: "+ buttonColor +"; ");


        HBox hbox = new HBox(button, label);
        Label label1 = new Label("Name:");
        TextField name = new TextField ();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        name.getText();
        hbox.getChildren().addAll(label1, name);
        hbox.setSpacing(10);

        Scene scene = new Scene(hbox, 200, 100);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();

    }
}