package sample;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


public class WorkoutSelect implements Initializable {

    ObservableList workoutTypes = FXCollections.observableArrayList();
    ObservableList workoutSpecs = FXCollections.observableArrayList();


    @FXML
    private SplitPane workoutScreen;

    @FXML
    private AnchorPane leadWorkoutPane;

    @FXML
    private ListView<String> workoutTypeListview;

    @FXML
    private ListView<String> workoutSpecListview;

    @FXML
    private Button AddButton;

    @FXML
    private Button ClearButton;

    @FXML
    private Button returnToFithub;

    @FXML
    private Button StartButton;

    @FXML
    private TextArea workoutText;

    static public String returnvalue;


    static ArrayList<String> WorkoutArray = new ArrayList<String>();
    ArrayList<String> WorkoutArrayToUserData = new ArrayList<String>();
    String choice;
    int counter = 0;


    @FXML
        //adds selected workouts to Arraylist
    void ExerciseAdd(ActionEvent event) {
            WorkoutArray.add(choice);
            returnvalue = choice;
            if (WorkoutArray.get(counter)==null){
            }else {
                workoutText.appendText(WorkoutArray.get(counter) + "\n");
            }
            counter++;

    }

    @FXML
        //Function that changes text of start button and prints completed workouts
    void StartWorkout(ActionEvent event) {
        String CurrentText = StartButton.getText();
        if (CurrentText.equals("Start") == false) {
            // all workouts performed by the user in the current run will be stored and sent elsewhere
            workoutText.setText("Workout Complete\n\n");
            for (String exercise : WorkoutArray) {
                    if (exercise == null){

                    }else{
                    workoutText.setText(workoutText.getText() + " " + exercise + "\n");
                    }
            }
            StartButton.setText("Start");
        } else {
            workoutText.setText("Workout in progress\n\n");
            for (String exercise : WorkoutArray) {
                if (exercise == null){

                }else{
                    workoutText.setText(workoutText.getText() + " " + exercise + "\n");
                }
            }
            StartButton.setText("Stop");
        }
    }

    @FXML
    //ExerciseClear Button
    void ExerciseClear(ActionEvent event){
        workoutText.clear();
        WorkoutArray.clear();
        counter = 0;
    }
    @FXML
    private void handleWorkButtonAction(ActionEvent event) throws IOException {
        //returnToFitHub Button Clicked
        if (event.getSource() == returnToFithub) {

            workoutText.clear();
            leadWorkoutPane.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("MainMenu.fxml")));

        }
    }

    //Shows specific exercises depending on which muscle group is selected
    public void SetExersizes(String workout) {
        workoutSpecs.clear();
        workoutSpecListview.getItems().clear();
    
        if (workout == "Cardio") {
            workoutSpecs.addAll("Jogging", "Sprints", "Jumping Jacks", "Biking", "Swimming", "Jump Rope",
                    "Stair Climbing", "Pick-up Basketball", "Rowing", "Boxing", "Burpees");
        } else if (workout == "Chest") {
            workoutSpecs.addAll("Barbell Bench Press", "Dumbbell Bench Press", "Decline Bench Press",
                    "Incline Bench Press", "Dumbbell Flies", "Incline Dumbbell Flies",
                    "Decline Dumbbell flies", "Push-ups", "Weighted Dips");
        } else if (workout == "Triceps") {
            workoutSpecs.addAll("Overhead Barbell Triceps Extension", "Triceps Extension", "Dips",
                    "Close-Grip Barbell Bench Press", "V-Bar Push-downs", "Dumbbell Triceps Extensions",
                    "Triangle Push-ups", "Kickbacks", "Rope Push-downs");
        } else if (workout == "Abdominal & Core") {
            workoutSpecs
                    .addAll("Crunches", "Sit-ups", "Side Crunches", "Raised Knee-ins", "Reverse Crunch",
                            "Planks", "Side Planks", "Russian Twist", "Bicycle Kicks", "V-Tucks", "Leg Raises");
        } else if (workout == "Legs") {
            workoutSpecs.addAll("Front Squats", "Back Squats", "Leg Curls", "Leg Extensions",
                    "Seated Calf Raises", "Standing Calf Raises", "Lunges", "Deadlift", "Hack Squat",
                    "Glute-Ham Raise");
        } else if (workout == "Biceps") {
            workoutSpecs
                    .addAll("Alternating Dumbbell Bicep Curls", "Barbell Bicep Curls", "EZ-Bar Bicep Curls",
                            "Preacher Curls", "Spider Curls", "Seated Incline Bicep Curls", "Crucifix Curls");
        } else if (workout == "Back") {
            workoutSpecs
                    .addAll("Romanian Deadlift", "Seated Rows", "Rear Trap Shrugs", "Back Hyper-extensions",
                            "Barbell Rows", "Dumbbell Rows", "Pull-ups", "Lateral Pull-downs",
                            "Close-grip Lateral Pull-downs");
        } else if (workout == "Shoulders") {
            workoutSpecs
                    .addAll("Bumbbell Shoulder Press", "Barbell Shoulder Press", "Lateral Side Delt Raises",
                            "Underhand Front Delt Raises", "Overhand Front Delt Raises", "Rear Delt Flies",
                            "Dumbbell Shoulder Shrugs", "Barbell Shoulder Shrugs");
        } else {
            workoutSpecs.addAll("error");
        }

        loadRightsideListview();
    }

    //loads all categories of given Workouts
    public void loadLeftsideListview() {

        String workA = "Cardio";
        String workB = "Chest";
        String workC = "Triceps";
        String workD = "Abdominal & Core";
        String workE = "Legs";
        String workF = "Biceps";
        String workG = "Back";
        String workH = "Shoulders";
        workoutTypeListview.getSelectionModel().selectedItemProperty()
                .addListener((v, oldval, newval) -> SetExersizes(newval));

        workoutTypes.addAll(workA, workB, workC, workD, workE, workF, workG, workH);
        workoutTypeListview.getItems().addAll(workoutTypes);

    }

//  public void ChooseWorkoutSet();

    public void loadRightsideListview() {

        //listener for selected exercise
        workoutSpecListview.getSelectionModel().selectedItemProperty()
                .addListener((v, oldval, newval) -> choice = newval);

        workoutSpecListview.getItems().addAll(workoutSpecs);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WorkoutArray.clear();
        // loads the list view options on screen start-up
        loadLeftsideListview();

    }
}

