package sample;

import java.io.File;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Login extends CreateAccount implements Initializable {

    /***************************************************************
     /* LOGIN FXML ELEMENTS
     ****************************************************************/
    
    
    static User user = new User();
    static String password = "";
    String email = "";

    @FXML
    private AnchorPane mainLoginScreen;

    @FXML
    private Label mainPasswordLabel;

    @FXML
    private Label mainUsernameLabel;

    @FXML
    private Label existingUsernameErrorMSG;

    @FXML
    private Label existingPasswordErrorMSG;

    @FXML
    private TextField mainUsernameInfo;

    @FXML
    private PasswordField mainPasswordInfo;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label welcomeText;

    @FXML
    private Label hook;



    /***************************************************************
     /* METHODS RELATED TO INPUT VERIFICATION
     ****************************************************************/



    /***************************************************************
     /* METHODS RELATED TO BUTTON PRESS
     ****************************************************************/
    @FXML
    void handleSignup(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

//  get reference to the button's stage
        stage = (Stage) signupButton.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Handling clicking Login Button
    @FXML
    void handleLogin(ActionEvent event) throws Exception {

        Stage stage;
        Parent root;
        //Search user method
        searchUsers();
        
        //Check if email exists, and checks if password is correct
        if (mainPasswordInfo.getText().equals(password) && CreateAccount.isValid(mainUsernameInfo.getText())) {
            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            //TODO: load user-specific data here and populate it across the other screens

        } else {
            // wrong email format input
            if (!CreateAccount.isValid(mainUsernameInfo.getText())) {
                existingUsernameErrorMSG.setText("* Incorrect email format. Please enter the proper format");
                existingUsernameErrorMSG.setVisible(true);

                existingPasswordErrorMSG.setText("* Password does not match with email. Please try again");
                existingPasswordErrorMSG.setVisible(true);
            }

            else {}
        }
    }
    
    //Search Textfile for email, then assigns all variables from textfile
    public void searchUsers() {

        try {
            Scanner sc = new Scanner(new File("src/sample/UserInfo.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().substring(4);
                if (mainUsernameInfo.getText().equals(line)) {
                    System.out.println("Email has been found");
                    user.name = sc.nextLine().substring(4);
                    user.username = sc.nextLine().substring(4);
                    password = sc.nextLine().substring(4);          ///MAKE SEX STRING
                    user.sex = sc.nextLine().substring(4);          ///MAKE AGE STRING
                    user.age = sc.nextLine().substring(4);
                    user.targetWeight = sc.nextLine().substring(4);       ///ADD TARGET WEIGHT
                    user.currentWeight = sc.nextLine().substring(4);    ///AD CURRENT WEIGHT

                } else {
                    existingUsernameErrorMSG.setText("* This email is not in our system. Try again or Create an Account");

                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    /***************************************************************
     /* ININTIALIZABLE
     ****************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        existingPasswordErrorMSG.setVisible(false);
        existingUsernameErrorMSG.setVisible(false);
    }
}



