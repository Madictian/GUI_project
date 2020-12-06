package side;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("project.fxml"));
        primaryStage.setTitle("Strange images and videos");
        primaryStage.setScene(new Scene(root,800, 600));
        primaryStage.show();
        primaryStage.setResizable(true);

        Stage stage = new Stage();
        String path = "";
/*
        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //Instantiating MediaView class
        MediaView mediaView = new MediaView(mediaPlayer);

        //by setting this property to true, the Video will be played
        mediaPlayer.setAutoPlay(true);

        //setting group and scene
        Group root1 = new Group();
        root1.getChildren().add(mediaView);
        Scene scene = new Scene(root,500,400);
        primaryStage.setScene(scene);
        */
        WebView webview = new WebView();
        WebEngine engine = webview.getEngine();

        engine.load("https://www.youtube.com/embed/pxkSfttYCrM");
        webview.setPrefSize(640, 390);
        stage.setTitle("vid");
        stage.setScene(new Scene(webview));
        stage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}