package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  static Stage window;

  @Override
  public void start(Stage primaryStage) throws Exception {

    window = primaryStage;

    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    primaryStage.setTitle("iCodeFit");
    primaryStage.setResizable(false);
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  public void changeScene(String fxml) throws IOException {

    Parent pane = FXMLLoader.load(getClass().getResource(fxml));
    Scene scene = new Scene(pane);
    window.setScene(scene);

  }

  public static void main(String[] args) {
    launch(args);
  }
}
