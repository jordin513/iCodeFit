package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NutritionTracker extends User implements Initializable {

    /***************************************************************
     /* DATA COLLECTED BY SCREEN
     ****************************************************************/

    String mealDescription;
    int Carbs;
    int Fats;
    int Protein;


    /***************************************************************
     /* NUTRITION TRACKER FXML ELEMENTS
     ****************************************************************/

    @FXML
    private AnchorPane nutritionTrackerAnchor;

    @FXML
    private Button backToFithubButton;

    @FXML
    private Button updateButton;

    @FXML
    private Label mealtypeLabel;

    @FXML
    private Label macrosLabel;

    @FXML
    private TextField fats;

    @FXML
    private TextField protein;

    @FXML
    private TextField carbs;

    @FXML
    private Label carbsLabel;

    @FXML
    private Label proteinLabel;

    @FXML
    private Label fatsLabel;

    @FXML
    private Label notAnumberErrorMSG;

    @FXML
    private TextArea mealtypeDescription;

    /***************************************************************
     /* INPUT VALIDATION
     ****************************************************************/
    public boolean checkMacrosInput() throws NumberFormatException {
        // checks that value given to these fields is a non-negative double value
        boolean correctMacros;
            try {
                Fats = Integer.parseInt(this.fats.getText());
                Carbs = Integer.parseInt(this.carbs.getText());
                Protein = Integer.parseInt(this.protein.getText());
                correctMacros = true;

            } catch (NumberFormatException hereNutTrackNaN) {
                notAnumberErrorMSG.setVisible(true);
                notAnumberErrorMSG.setWrapText(true);
                notAnumberErrorMSG.setMaxWidth(90);
                correctMacros = false;

            }

            return correctMacros;
        }


    /***************************************************************
     /* METHODS RELATED TO THE SCREEN
     ****************************************************************/

    @FXML
    private void handleNutTrackButtonAction(ActionEvent event) throws IOException {

        if (event.getSource() == updateButton && checkMacrosInput() == true) {

            nutritionTrackerAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("MainMenu.fxml")));


        } else if (event.getSource() == backToFithubButton) {

            nutritionTrackerAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource(
                    "MainMenu.fxml")));
        }

    }


    /***************************************************************
     /* INITIALIZABLE
     ****************************************************************/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        notAnumberErrorMSG.setVisible(false);
        notAnumberErrorMSG.setText("* One of your macros inputs is incorrect.\n"
                + "Please make sure to enter non-negative\n"
                + "integer values in this section.");
        notAnumberErrorMSG.setWrapText(true);

    }
}
