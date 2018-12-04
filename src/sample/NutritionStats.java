package sample;

import static sample.WorkoutSelect.WorkoutArray;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NutritionStats extends User implements Initializable {

    testNutritionStatsDriver thisRun = new testNutritionStatsDriver();

    /***************************************************************
     /* NUTRITION STATISTICS DISPLAY FXML
     ****************************************************************/

    @FXML
    private LineChart<String, Integer> weightLossLineGraph;

    @FXML
    private BarChart<String, Number> macrosBarGraph;

    @FXML
    private Label currWeightStatLabel;

    @FXML
    private Label currWeightGoalStatLabel;

    @FXML
    private Label lastWorkoutStatLabel;

    @FXML
    private Label lastMealStatLabel;

    @FXML
    private Label currWeightVal;

    @FXML
    private Label currWeightGoalVal;

    @FXML
    private Label lastWorkoutVal;

    @FXML
    private Button returnToFitHub;


    /***************************************************************
     /* METHODS RELATED TO INFORMATION DISPLAY
     ****************************************************************/
    /* The method currently reads values from a driver class. This will be replaced with an User class */

    public void generalLabelSettings() {

        currWeightVal.setText(Double.toString(thisRun.getUserCurrWeight()));
        currWeightGoalVal.setText(Double.toString(thisRun.getUserGoalWeight()));
        lastWorkoutVal.setWrapText(true);
        lastWorkoutVal.setText(thisRun.getUserLastWorkout());

    }

    public void populateLineGraph() {
        // creates the graph and populates the data
        XYChart.Series series = new XYChart.Series();
        weightLossLineGraph.setTitle("Your progress");
        weightLossLineGraph.getXAxis().setLabel("Weighing Day");
        weightLossLineGraph.getYAxis().setLabel("Weight");
        series.setName("Weight since joined");

        // Add while loop here
        series.getData().add(new XYChart.Data("8/23", 212));
        series.getData().add(new XYChart.Data("8/27", 212));
        series.getData().add(new XYChart.Data("8/29", 212));
        weightLossLineGraph.getData().add(series);
    }

    public void populateBarGraph() {
        macrosBarGraph.setTitle("Macronutrients Distribution");
        macrosBarGraph.getXAxis().setLabel("Macronutrients");
        macrosBarGraph.getYAxis().setLabel("Value");

        //Add while loop here
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Protein", 15));
        series.getData().add(new XYChart.Data("Carbs", 40));
        series.getData().add(new XYChart.Data("Fats", 8));
        macrosBarGraph.getData().add(series);

    }


    /***************************************************************
     /* INITIALIZABLE
     ****************************************************************/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generalLabelSettings();
        populateLineGraph();
        populateBarGraph();

        lastWorkoutVal.setText( WorkoutArray.get(0));

    }

    /***************************************************************
     /* METHODS RELATED TO BUTTON PRESS
     ****************************************************************/

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Stage stage;
        Parent root;

        if(event.getSource()==returnToFitHub){
            //get reference to the button's stage
            stage=(Stage) returnToFitHub.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        }
        else{
            stage=(Stage) returnToFitHub.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
