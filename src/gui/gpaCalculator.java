package gui;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class gpaCalculator extends Application {
    private TextField tfNumberOfHighDistinctions = new TextField();
    private TextField tfNumberOfDistinctions = new TextField();
    private TextField tfNumberOfCredits = new TextField();
    private TextField tfNumberOfPasses = new TextField();
    private TextField tfNumberOfFails = new TextField();
    private TextField tfGPA = new TextField();
    private Button btCalculateGPA = new Button("Calculate GPA");

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Number of High Distinctions"), 0, 0);
        gridPane.add(tfNumberOfHighDistinctions, 1, 0);
        gridPane.add(new Label("Number of Distinctions"), 0, 1);
        gridPane.add(tfNumberOfDistinctions, 1, 1);
        gridPane.add(new Label("Number of Credits"), 0, 2);
        gridPane.add(tfNumberOfCredits, 1, 2);
        gridPane.add(new Label("Number of Passes"), 0, 3);
        gridPane.add(tfNumberOfPasses, 1, 3);
        gridPane.add(new Label("Number of Fails"), 0, 4);
        gridPane.add(tfNumberOfFails, 1, 4);
        gridPane.add(new Label("Current GPA"), 0, 5);
        gridPane.add(tfGPA, 1, 5);
        gridPane.add(btCalculateGPA, 1, 6);

        gridPane.setAlignment(Pos.CENTER);
        tfNumberOfHighDistinctions.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfDistinctions.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfCredits.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfPasses.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfFails.setAlignment(Pos.BOTTOM_RIGHT);
        tfGPA.setAlignment(Pos.BOTTOM_RIGHT);
        tfGPA.setEditable(false);
        GridPane.setHalignment(btCalculateGPA, HPos.RIGHT);

        btCalculateGPA.setOnAction(e -> calculateGPAtotal());

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("gpaClaculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateGPAtotal() {
        final double HD_GRADE_VAL = 48.0;
        final double D_GRADE_VAL = 36.0;
        final double C_GRADE_VAL = 24.0;
        final double P_GRADE_VAL = 12.0;
        final double N_GRADE_VAL = 0.0;
        final double UNIT_LOAD_VAL = 12.0;

        int HDs = Integer.parseInt(tfNumberOfHighDistinctions.getText());
        int Ds = Integer.parseInt(tfNumberOfDistinctions.getText());
        int Cs = Integer.parseInt(tfNumberOfCredits.getText());
        int Ps = Integer.parseInt(tfNumberOfPasses.getText());
        int Ns = Integer.parseInt(tfNumberOfFails.getText());

        double GPA = ((HDs * HD_GRADE_VAL) + (Ds * D_GRADE_VAL) + (Cs * C_GRADE_VAL) +
                (Ps * P_GRADE_VAL) + (Ns * N_GRADE_VAL)) / ((HDs * UNIT_LOAD_VAL) +
                (Ds * UNIT_LOAD_VAL) + (Cs * UNIT_LOAD_VAL) + (Ps * UNIT_LOAD_VAL) +
                (Ns * UNIT_LOAD_VAL));
        tfGPA.setText(String.format("%.2f", GPA));
    }
}