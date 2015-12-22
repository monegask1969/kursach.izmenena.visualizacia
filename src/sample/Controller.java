package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.io.File;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Controller {
    @FXML
    private TextField arr;
    @FXML
    private Label time;
    @FXML
    private byte[] bytes;
    @FXML
    private File file;
    @FXML
    ScrollPane scrollPane;
    private Pane pane;
    private int length;
    @FXML
    private Label qsteps;

    @FXML
    void Exit() {
        Platform.exit();
    }

    @FXML
    private Button showarray;

    @FXML
    public void InsertSort() {
        pane = new Pane();
        byte[] a = Arrays.copyOf(bytes, length);
        Insertionsort.insort(a);
        time.setText("" + Insertionsort.secs / 1000000 + " secs");
        qsteps.setText("" + Insertionsort.steps);
        pane.getChildren().addAll(ShowBytes.rectangles(a, Integer.parseInt(arr.getText())));
        scrollPane.setContent(pane);
        Insertionsort.steps = 0;
    }

    @FXML
    public void Quicksort() {
        pane = new Pane();
        byte[] a = Arrays.copyOf(bytes, length);
        QuickSort.qSort(a, 0, a.length - 1);
        time.setText("" + QuickSort.secs / 1000000 + " secs");
        qsteps.setText("" + QuickSort.steps);
        pane.getChildren().addAll(ShowBytes.rectangles(a, Integer.parseInt(arr.getText())));
        scrollPane.setContent(pane);
        QuickSort.steps = 0;
    }

    @FXML
    public void ShowArr() {
        length = Integer.parseInt(arr.getText());
        pane = new Pane();
        byte[] a = Arrays.copyOf(bytes, length);
        pane.getChildren().addAll(ShowBytes.rectangles(a, length));
        scrollPane.setContent(pane);
        time.setText("0");
        qsteps.setText("0");
    }

    @FXML
    public void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Path p = FileSystems.getDefault().getPath(String.valueOf(file));
            try {
                bytes = Files.readAllBytes(p);
                System.out.println(bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void insertionSortSteps() {
        Insertionsort insertionsort = new Insertionsort();

    }

    @FXML
    public void Help() {
        try {
            new ProcessBuilder("cmd", "/c", "start", "help\\index.htm").start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
