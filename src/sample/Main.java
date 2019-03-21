package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Scene scene;
    private Stage stage;
    private Pane pane;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        try{
            pane = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(pane,308,308);
        stage.setScene(scene);
        stage.setTitle("Конвектор");
        stage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
