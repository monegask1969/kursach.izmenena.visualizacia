package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("The Sorter");
        primaryStage.setScene(new Scene(root, 611, 400));
        primaryStage.getScene().getStylesheets().add("C:\\Users\\Макс\\IdeaProjects\\grebaniykursach\\src\\css\\2.css");
        primaryStage.show();
    }


    public static void main(String[] args) {launch(args);
    }
}
