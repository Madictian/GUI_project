package side;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Scanner;

public class Controller {


    @FXML
    private TabPane buttombitch;

    @FXML
    private AnchorPane background;

    @FXML
    private ChoiceBox funny;

    @FXML
    private ImageView memes;

    @FXML
    private ImageView harold;

    @FXML
    private Button starter;

    @FXML
    private Button reSize;

    @FXML
    private TextField awesomeField;

    @FXML
    private Text averageScore;


    @FXML
    void showImage(ActionEvent event) throws IllegalArgumentException, FileNotFoundException {

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
        setAverage();
    }


    @FXML
    void setAverage() throws FileNotFoundException {
        int averager = 0;
        int total = 0;
        java.io.File file = new java.io.File("C:\\Users\\fredr\\IdeaProjects\\GUI_project\\stats.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()){
            if (input.next().equals(funny.getValue())){
                total += input.nextInt();
                averager++;
            }
        }
        try {
            averageScore.setText(String.valueOf(total / averager));
        }catch (ArithmeticException e){
            System.out.println("fool, you cant divde by zero");
        }
    }


    @FXML
    void reSizeImage(MouseEvent event) {

        if (event.getButton() == MouseButton.PRIMARY){
            if (memes.isPreserveRatio()) {
            memes.setPreserveRatio(false);
            } else {
            memes.setPreserveRatio(true);
            }
        }
    }


    @FXML
    void saveForStats(KeyEvent event) throws FileNotFoundException {
        if (event.getCode() == KeyCode.ENTER){
            String score = awesomeField.getText();
            int realscore = Integer.parseInt(score);
            if (realscore > 10){
                realscore = 10;
            } else if (realscore < 0){
                realscore = 0;
            }
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
        setAverage();

    }

   @FXML
    void initialize(){
        harold.fitHeightProperty().bind(buttombitch.heightProperty());
        harold.fitWidthProperty().bind(buttombitch.widthProperty());
    }
}
