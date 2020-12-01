package side;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Scanner;

public class Controller {


    @FXML
    private ChoiceBox funny;

    @FXML
    private ImageView memes;

    @FXML
    private Button starter;

    @FXML
    private Button reSize;

    @FXML
    private TextField awesomeField;

    @FXML
    void showImage(ActionEvent event) throws IllegalArgumentException {

        String billede = (String) funny.getValue();
        Date d = new Date();

        if (!billede.isEmpty() || !billede.isBlank()) {
            try {
                String file = billede + ".jpg";
                Image image = new Image("memers/" + file);
                memes.setImage(image);
            } catch (IllegalArgumentException e) {
                String file = billede + ".gif";
                Image image = new Image("memers/" + file);
                memes.setImage(image);
            }
        }

    }

    @FXML
    void reSizeImage(ActionEvent event) {

        if (memes.isPreserveRatio()) {
            memes.setPreserveRatio(false);
        }else {
            memes.setPreserveRatio(true);
        }

    }

    @FXML
    void saveForStats(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER){
            String score = awesomeField.getText();
            int realscore = Integer.parseInt(score);
            System.out.println(realscore);

            try {
                java.io.File file = new java.io.File("stats");
                Scanner input = new Scanner(file);

                Writer fileWriter = new FileWriter("stats.txt", true);
                fileWriter.write(funny.getValue() + " " + realscore + " ");
                fileWriter.close();

            }catch (IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
