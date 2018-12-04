package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenu implements Initializable {

    // used to switch screens
    Stage stageMainMenu;
    Parent rootMainMenu;


    @FXML
    private TabPane mainMenuTabs;

    /***************************************************************
     /* FITHUB TAB FXML ELEMENTS
     ****************************************************************/
    @FXML
    private Tab fithubTab;

    @FXML
    private AnchorPane fithubAnchor;

    @FXML
    private Pane selectWorkoutPane;

    @FXML
    private Label ExeLabel1;

    @FXML
    private Button selectWorkoutButton;

    @FXML
    private Pane customWorkoutPane;

    @FXML
    private Label ExeLabel2;

    @FXML
    private Button customWorkoutButton;

    @FXML
    private Pane nutritionStatsPane;

    @FXML
    private Label ExeLabel4;

    @FXML
    private Button nutritionStatsButton;

    @FXML
    private Pane nutritionTrackerPane;

    @FXML
    private Label ExeLabel5;

    @FXML
    private Button nutritionTrackerButton;

    /***************************************************************
     /* FEED TAB FXML ELEMENTS
     ****************************************************************/

    @FXML
    private Tab feedTab;

    @FXML
    private AnchorPane feedAnchor;

    @FXML
    private Pane feedMSG1;

    @FXML
    private Label usernameFeedDisplay;

    @FXML
    private Label workoutPresetMSG;

    @FXML
    private ImageView pfpFeedDisplay;

    @FXML
    private Pane feedMSG4;

    @FXML
    private Label usernameFeedDisplay1;

    @FXML
    private ImageView pfpFeedDisplay1;

    @FXML
    private Label nutritionlogPresetMSG;

    @FXML
    private Label mealDescriptionMSG;

    @FXML
    private Label carbsMSG;

    @FXML
    private Label proteinMSG;

    @FXML
    private Label fatsMSG;

    /***************************************************************
     /* SETTINGS TAB FXML ELEMENTS
     ****************************************************************/

    @FXML
    private Tab settingsTab;

    @FXML
    private AnchorPane settingsAnchor;

    @FXML
    private Accordion generalSettings;

    @FXML
    private TitledPane workoutSettings;

    @FXML
    private TitledPane profileSettings;

    @FXML
    private TitledPane nutritionSettings;

    @FXML
    private Button changeUserProfileButton;

    @FXML
    private ImageView userPFP;

    @FXML
    private Label nameDisplay;

    @FXML
    private Label usernameDisplay;

    @FXML
    private Button signoutButton;

    @FXML
    private Label SexAgeLabel;


    /***************************************************************
     /* METHODS RELATED TO FITHUB ITEMS
     ****************************************************************/

    @FXML
    private void handleFitHubButtonAction(ActionEvent event) throws IOException {

        if (event.getSource() == selectWorkoutButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("WorkoutSelect.fxml")));

        }

        else if (event.getSource() == nutritionStatsButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource(
                "NutritionStats.fxml")));

        }

        else if (event.getSource() == customWorkoutButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("sample.fxml")));

        }

        else if (event.getSource() == nutritionTrackerButton) {

            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource(
                "NutritionTracker.fxml")));
        }

        else if (event.getSource() == signoutButton) {

            stageMainMenu=(Stage) signoutButton.getScene().getWindow();
            //load up main menu FXML document
            try {
                rootMainMenu = FXMLLoader.load(getClass().getResource("Login.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene = new Scene(rootMainMenu);
            stageMainMenu.setScene(scene);
            stageMainMenu.show();

        }

        else if (event.getSource() == changeUserProfileButton) {

            stageMainMenu=(Stage) changeUserProfileButton.getScene().getWindow();
            //load up main menu FXML document
            try {
                rootMainMenu = FXMLLoader.load(getClass().getResource("Profile.fxml"));
                new Profile().setChecker(7);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene = new Scene(rootMainMenu);
            stageMainMenu.setScene(scene);
            stageMainMenu.show();

        }

        else {

            // known bug: doing this creates a copy of the entire main menu screen (tabs included))
            // This can be solved by setting the default 4-option fit hub menu into its own FXML file that is loaded
            // within the Fit hub tab's tab pane.
            fithubAnchor.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        }


    }

    /***************************************************************
     /* METHODS RELATED TO SETTINGS ITEMS
     ****************************************************************/
    // TODO: Complete Settings Tab Items




    /***************************************************************
     /* GENERAL INITIALIZABLE FOR ALL TAB PANES
     ****************************************************************/

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        nameDisplay.setText(Login.user.name);
        usernameDisplay.setText(Login.user.username);
        SexAgeLabel.setText("Sex: "+Login.user.sex + " Age: "+ Login.user.age);
        usernameFeedDisplay.setText(Login.user.username);
        usernameFeedDisplay1.setText(Login.user.username);


    }


}
