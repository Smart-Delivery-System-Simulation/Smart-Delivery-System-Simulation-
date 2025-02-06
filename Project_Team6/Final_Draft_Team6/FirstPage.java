import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class FirstPage extends Application {
    public static boolean isPhase1Selected = false;
    public static boolean isPhase2Selected = false;
   public static Button phase2Button ;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Best Route Application");



        // Create label
        Label titleLabel = new Label("Best Route to Deliver Packages");
        titleLabel.setStyle(
            "-fx-font-size: 22px; " +      // Font size
            "-fx-text-fill: #F0F2F0; " +   // Blue text color
            "-fx-font-weight: bold;"       // Bold font
        );
        titleLabel.setAlignment(Pos.CENTER);

        // Create buttons
        Button phase1Button = new Button("Phase 1");   

        phase2Button = new Button("Phase 2");

        phase1Button.setOnAction(e -> {
            isPhase1Selected = true;
            openSimulationPage();
            primaryStage.close();
        });
        phase2Button.setOnAction(e -> {

            isPhase2Selected = true;  
            openSimulationPage();
            primaryStage.close();
            MainProgram.packages=MainProgram.clonePackages(MainProgram.packages);
            MainGUISimulation.CounterGasolinLabe1_phase1_to_2.setText(MainGUISimulation.formatGasolineCost(MainGUISimulation.total_GasolineCost));
            MainGUISimulation.CounterDistanceLabe1_phase1_to_2.setText(MainGUISimulation.formatDistance(MainGUISimulation.total_Distance));
            MainGUISimulation.CountertimeLabe1_phase1_to_2.setText(MainGUISimulation.formatTime(MainGUISimulation.total_Time));

           
        });
       // Make buttons bigger
        phase1Button.setStyle(
                "-fx-background-color: #000C40; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " + // Increase font size
                "-fx-background-radius: 100 100 100 100;" // Set larger background radii (top-left, top-right, bottom-right, bottom-left)
            );

        phase2Button.setStyle(
                "-fx-background-color: #000C40; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 20px; " + // Increase font size
                "-fx-background-radius: 100 100 100 100;"
            );
        // Create GridPane for buttons
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(40); // Set horizontal gap between buttons (increased from 20)

        // Add buttons to GridPane
        gridPane.add(phase1Button, 0, 0);
        gridPane.add(phase2Button, 1, 0);

        // Create BorderPane for the main layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        borderPane.setCenter(gridPane);

        borderPane.setStyle(
            "-fx-background: linear-gradient(to bottom, #000C40, #F0F2F0);" +
            "-fx-background-size: cover;"
        );
        phase2Button.setDisable(true); 

        enablePhase2();
        // Bind properties for dynamic resizing
        DoubleProperty titleLabelWidth = titleLabel.prefWidthProperty();
        ReadOnlyDoubleProperty borderPaneWidthProp = borderPane.widthProperty();
        titleLabelWidth.bind(borderPaneWidthProp);

        DoubleProperty titleLabelHeight = titleLabel.prefHeightProperty();
        ReadOnlyDoubleProperty borderPaneHeightProp = borderPane.heightProperty();
        titleLabelHeight.bind(borderPaneHeightProp.multiply(0.2));

        DoubleProperty gridPaneWidth = gridPane.prefWidthProperty();
        gridPaneWidth.bind(borderPaneWidthProp);

        DoubleProperty gridPaneHeight = gridPane.prefHeightProperty();
        gridPaneHeight.bind(borderPaneHeightProp.multiply(0.8));
 

        // Set minimum width and height for the stage
        primaryStage.setMinWidth(400); 
        primaryStage.setMinHeight(300); 
        // Create Scene
        Scene scene = new Scene(borderPane, 400, 300); 

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
    public static void enablePhase2() {
        if (MainGUISimulation.isPhase1comblete) {
            phase2Button.setDisable(false);  
        }
    }
    private void openSimulationPage() {
        MainGUISimulation  SimulationPage = new MainGUISimulation (); // Create an instance of FirstPage
        Stage stage = new Stage(); // Create a new stage
        SimulationPage.start(stage); // Call the start method of FirstPage, passing the new stage
    }

    public static void main(String[] args) {
        MainProgram.initializeObjects();
        launch(args);

    }
   
   
}
