import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




public class MainGUISimulation extends Application {
private static Label CounterTimeLabel;
public static Label CounterDistanceLabel;
public static Label CounterCostLabel;
public static Label CounterNo_SimulationLabel ;
public static Label percentLabelP2;
public static Pane AllGroups;
public Group carRoutesGroup;
private  Timer timer;
public  int secondsPassed = 0;
public static  boolean isStartClicked=true;
public static boolean isPaused = false;
public static int numOfSumuolation = 0;
public static Rectangle car ;
public StackPane root;
public static int totalTimeP1;
public static int totalTimeP2;
public static List<Rectangle> buildings ;
public static Label CounterGasolinLabe1_phase1_to_2 ;
public static double total_Distance;
public static int total_Time;
public static double total_GasolineCost;
public static Label CounterDistanceLabe1_phase1_to_2 ;
public static Label  CountertimeLabe1_phase1_to_2;


public static boolean isPhase1comblete =false ; 

    public void start(Stage primaryStage) {
        primaryStage.setOnCloseRequest(windowEvent -> {Platform.exit();System.exit(0);});
    
            AllGroups = new Pane();

            root = new StackPane();
            root.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #000C40, #F0F2F0);" +
                "-fx-background-size: cover;"
            );

            // Create a group for car routes
            carRoutesGroup = new Group();
            car = new Rectangle(323, 642, 15, 15);
            car.setArcHeight(15);
            car.setArcWidth(15);
            car.setFill(Color.RED);
            carRoutesGroup.getChildren().add(car);

            Scene scene = new Scene(root , 1400, 700);


            buildings(AllGroups);
            streets(AllGroups);
            Labels(AllGroups,FirstPage.isPhase2Selected);       
            Buttons(AllGroups,primaryStage); 
            AllGroups.getChildren().addAll(carRoutesGroup);

            root.getChildren().add(AllGroups);
            primaryStage.setTitle("GUI Simulation");
            primaryStage.setMinWidth(1350);
            primaryStage.setMinHeight(720); 
            primaryStage.setScene(scene );
            primaryStage.show();
            addToolTipsToAllBuildings();

    }


    public static void buildings(Pane AllGroups){
    
        Font font = new Font("Times New Roman",25);

        
        // Neighbourhood_1 : BLOCK 1
        Rectangle Building1 = new Rectangle(50, 20, 35, 35);
        Building1.setArcHeight(20);
        Building1.setArcWidth(20);
        Building1.setFill(Color.GREY); 
         
        
       
        Rectangle Building2 = new Rectangle(160, 20, 35, 35);
        Building2.setArcHeight(20);
        Building2.setArcWidth(20);
        Building2.setFill(Color.GREY);
        
        Rectangle Building3 = new Rectangle(270, 20, 35, 35);
        Building3.setArcHeight(20);
        Building3.setArcWidth(20);
        Building3.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 2
        Rectangle Building4 = new Rectangle(350, 20, 35, 35);
        Building4.setArcHeight(25);
        Building4.setArcWidth(25);
        Building4.setFill(Color.GREY); 
        
        Rectangle Building5 = new Rectangle(425, 20, 35, 35);
        Building5.setArcHeight(25);
        Building5.setArcWidth(25);
        Building5.setFill(Color.GREY);

        Rectangle Building6 = new Rectangle(490, 20, 35, 35);
        Building6.setArcHeight(25);
        Building6.setArcWidth(25);
        Building6.setFill(Color.GREY);
 
        
         Rectangle Building7 = new Rectangle(550, 20, 35, 35);
         Building7.setArcHeight(25);
         Building7.setArcWidth(25);
         Building7.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 3
        Rectangle Building8 = new Rectangle(640, 20, 35, 35);
        Building8.setArcHeight(25);
        Building8.setArcWidth(25);
        Building8.setFill(Color.GREY);
 
        
        Rectangle Building9 = new Rectangle(710, 20, 35, 35);
        Building9.setArcHeight(25);
        Building9.setArcWidth(25);
        Building9.setFill(Color.GREY);

        Rectangle Building10 = new Rectangle(790, 20, 35, 35);
        Building10.setArcHeight(25);
        Building10.setArcWidth(25);
        Building10.setFill(Color.GREY);

 
        
        // Neighbourhood_1 : BLOCK 4
        Rectangle Building11 = new Rectangle(880, 20, 35, 35);
        Building11.setArcHeight(25);
        Building11.setArcWidth(25);
        Building11.setHeight(35);
        Building11.setWidth(70);
        Building11.setFill(Color.GREY);
 
        
        Rectangle Building12 = new Rectangle(970, 20, 35, 35);
        Building12.setArcHeight(25);
        Building12.setArcWidth(25);
        Building12.setHeight(35);
        Building12.setWidth(70);
        Building12.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 5
        Rectangle Building13 = new Rectangle(50, 80, 35, 35);
        Building13.setArcHeight(25);
        Building13.setArcWidth(25);
        Building13.setFill(Color.GREY);
 
        
        Rectangle Building14 = new Rectangle(125, 80, 35, 35);
        Building14.setArcHeight(25);
        Building14.setArcWidth(25);
        Building14.setFill(Color.GREY);
 
        Rectangle Building15 = new Rectangle(200, 80, 35, 35);
        Building15.setArcHeight(25);
        Building15.setArcWidth(25);
        Building15.setFill(Color.GREY);

        
        Rectangle Building16 = new Rectangle(270, 80, 35, 35);
        Building16.setArcHeight(25);
        Building16.setArcWidth(25);
        Building16.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 6
        
        Rectangle Building17 = new Rectangle(350, 80, 35, 35);
        Building17.setArcHeight(25);
        Building17.setArcWidth(25);
        Building17.setFill(Color.GREY);
        
        Rectangle Building18 = new Rectangle(460, 80, 35, 35);
        Building18.setArcHeight(25);
        Building18.setArcWidth(25);
        Building18.setFill(Color.GREY);
        
        Rectangle Building19 = new Rectangle(550, 80, 35, 35);
        Building19.setArcHeight(25);
        Building19.setArcWidth(25);
        Building19.setFill(Color.GREY);

        // Neighbourhood_1 : BLOCK 7
        Rectangle Building20 = new Rectangle(625, 80, 35, 35);
        Building20.setArcHeight(25);
        Building20.setArcWidth(25);
        Building20.setFill(Color.GREY);

        
        Rectangle Building21 = new Rectangle(680, 80, 35, 35);
        Building21.setArcHeight(25);
        Building21.setArcWidth(25);
        Building21.setFill(Color.GREY);

        Rectangle Building22 = new Rectangle(740, 80, 35, 35);
        Building22.setArcHeight(25);
        Building22.setArcWidth(25);
        Building22.setFill(Color.GREY);

        
        Rectangle Building23 = new Rectangle(800, 80, 35, 35);
        Building23.setArcHeight(25);
        Building23.setArcWidth(25);
        Building23.setFill(Color.GREY);

        
        // Neighbourhood_1 : BLOCK 8
        Rectangle Building24 = new Rectangle(875, 80, 35, 35);
        Building24.setArcHeight(25);
        Building24.setArcWidth(25);
        Building24.setFill(Color.GREY);
 
        
        Rectangle Building25 = new Rectangle(950, 80, 35, 35);
        Building25.setArcHeight(25);
        Building25.setArcWidth(25);
        Building25.setFill(Color.GREY);

        
        Rectangle Building26 = new Rectangle(1020, 80, 35, 35);
        Building26.setArcHeight(25);
        Building26.setArcWidth(25);
        Building26.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 9
        Rectangle Building27 = new Rectangle(50, 150, 35, 35);
        Building27.setArcHeight(25);
        Building27.setArcWidth(25);
        Building27.setFill(Color.GREY);
        
        Rectangle Building28 = new Rectangle(160, 150, 35, 35);
        Building28.setArcHeight(25);
        Building28.setArcWidth(25);
        Building28.setFill(Color.GREY);
        
        
        
        Rectangle Building29 = new Rectangle(270, 150, 35, 35);
        Building29.setArcHeight(25);
        Building29.setArcWidth(25);
        Building29.setFill(Color.GREY);
        
        
        // Neighbourhood_1 : BLOCK 10
        
        Rectangle Building30 = new Rectangle(350, 150, 35, 35);
        Building30.setArcHeight(25);
        Building30.setArcWidth(25);
        Building30.setFill(Color.GREY);
        
        Rectangle Building31 = new Rectangle(425, 150, 35, 35);
        Building31.setArcHeight(25);
        Building31.setArcWidth(25);
        Building31.setFill(Color.GREY);
        
        Rectangle Building32 = new Rectangle(490, 150, 35, 35);
        Building32.setArcHeight(25);
        Building32.setArcWidth(25);
        Building32.setFill(Color.GREY);
        
        Rectangle Building33 = new Rectangle(550, 150, 35, 35);
        Building33.setArcHeight(25);
        Building33.setArcWidth(25);
        Building33.setFill(Color.GREY);
        
        
        // Neighbourhood_1 : BLOCK 11
        
        Rectangle Building34 = new Rectangle(630, 150, 35, 35);
        Building34.setArcHeight(25);
        Building34.setArcWidth(25);
        Building34.setFill(Color.GREY);
        
        Rectangle Building35 = new Rectangle(710, 150, 35, 35);
        Building35.setArcHeight(25);
        Building35.setArcWidth(25);
        Building35.setFill(Color.GREY);
        
        Rectangle Building36 = new Rectangle(790, 150, 35, 35);
        Building36.setArcHeight(25);
        Building36.setArcWidth(25);
        Building36.setFill(Color.GREY);
          
       // Neighbourhood_1 : BLOCK 12
       
        Rectangle Building37 = new Rectangle(870, 150, 35, 35);
        Building37.setArcHeight(25);
        Building37.setArcWidth(25);
        Building37.setFill(Color.GREY);
        
        Rectangle Building38 = new Rectangle(920, 150, 35, 35);
        Building38.setArcHeight(25);
        Building38.setArcWidth(25);
        Building38.setFill(Color.GREY);
        
        Rectangle Building39 = new Rectangle(970, 150, 35, 35);
        Building39.setArcHeight(25);
        Building39.setArcWidth(25);
        Building39.setFill(Color.GREY);
        
        Rectangle Building40 = new Rectangle(1020, 150, 35, 35);
        Building40.setArcHeight(25);
        Building40.setArcWidth(25);
        Building40.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 13 
        
        Rectangle Building41 = new Rectangle(50, 215, 35, 35);
        Building41.setArcHeight(25);
        Building41.setArcWidth(25);
        Building41.setFill(Color.GREY);
        
        Rectangle Building42 = new Rectangle(165, 215, 35, 35);
        Building42.setArcHeight(25);
        Building42.setArcWidth(25);
        Building42.setFill(Color.GREY);
        
        Rectangle Building43 = new Rectangle(270, 215, 35, 35);
        Building43.setArcHeight(25);
        Building43.setArcWidth(25);
        Building43.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 14 
        
        Rectangle Building44 = new Rectangle(360, 215, 35, 35);
        Building44.setArcHeight(25);
        Building44.setArcWidth(25);
        Building44.setHeight(35);
        Building44.setWidth(80);
        Building44.setFill(Color.GREY);
        
        Rectangle Building45 = new Rectangle(495, 215, 35, 35);
        Building45.setArcHeight(25);
        Building45.setArcWidth(25);
        Building45.setHeight(35);
        Building45.setWidth(80);
        Building45.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 15 
        Rectangle Building46 = new Rectangle(620, 215, 35, 35);
        Building46 .setArcHeight(25);
        Building46.setArcWidth(25);
        Building46.setFill(Color.GREY);
        
        Rectangle Building47 = new Rectangle(680, 215, 35, 35);
        Building47.setArcHeight(25);
        Building47.setArcWidth(25);
        Building47.setFill(Color.GREY);
        
        Rectangle Building48 = new Rectangle(740, 215, 35, 35);
        Building48.setArcHeight(25);
        Building48.setArcWidth(25);
        Building48.setFill(Color.GREY);
        
        Rectangle Building49 = new Rectangle(800, 215, 35, 35);
        Building49.setArcHeight(25);
        Building49.setArcWidth(25);
        Building49.setFill(Color.GREY);
        
        // Neighbourhood_1 : BLOCK 16
        Rectangle Building50 = new Rectangle(880, 215, 35, 35);
        Building50.setArcHeight(25);
        Building50.setArcWidth(25);
        Building50.setFill(Color.GREY);
        
        Rectangle Building51 = new Rectangle(950, 215, 35, 35);
        Building51.setArcHeight(25);
        Building51.setArcWidth(25);
        Building51.setFill(Color.GREY);
        
        Rectangle Building52 = new Rectangle(1010, 215, 35, 35);
        Building52.setArcHeight(25);
        Building52.setArcWidth(25);
        Building52.setFill(Color.GREY);
        
        // Neighbourhood 2 ( from Building 53 to Building 91 ) with 12 blocks :
        
  
        
        // Neighbourhood_2 : BLOCK 1
        Rectangle Building53 = new Rectangle(50, 280, 35, 35);
        Building53.setArcHeight(25);
        Building53.setArcWidth(25);
        Building53.setFill(Color.BLUE);;
        
        Rectangle Building54 = new Rectangle(125, 280, 35, 35);
        Building54.setArcHeight(25);
        Building54.setArcWidth(25);
        Building54.setFill(Color.BLUE);
        
        Rectangle Building55 = new Rectangle(200, 280, 35, 35);
        Building55.setArcHeight(25);
        Building55.setArcWidth(25);
        Building55.setFill(Color.BLUE);
        
        Rectangle Building56 = new Rectangle(270, 280, 35, 35);
        Building56.setArcHeight(25);
        Building56.setArcWidth(25);
        Building56.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 2
        
        Rectangle Building57 = new Rectangle(370, 280, 35, 35);
        Building57.setArcHeight(25);
        Building57.setArcWidth(25);
        Building57.setFill(Color.BLUE);
        
        Rectangle Building58 = new Rectangle(460, 280, 35, 35);
        Building58.setArcHeight(25);
        Building58.setArcWidth(25);
        Building58.setFill(Color.BLUE);
        
        Rectangle Building59 = new Rectangle(540, 280, 35, 35);
        Building59.setArcHeight(25);
        Building59.setArcWidth(25);
        Building59.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 3 :
        
        Rectangle Building60 = new Rectangle(630, 280, 35, 35);
        Building60 .setArcHeight(25);
        Building60.setArcWidth(25);
        Building60.setFill(Color.BLUE);
        
        
        Rectangle Building61 = new Rectangle(690, 280, 35, 35);
        Building61.setArcHeight(25);
        Building61.setArcWidth(25);
        Building61.setFill(Color.BLUE);
        
        Rectangle Building62 = new Rectangle(750, 280, 35, 35);
        Building62.setArcHeight(25);
        Building62.setArcWidth(25);
        Building62.setFill(Color.BLUE);
        
        Rectangle Building63 = new Rectangle(810, 280, 35, 35);
        Building63.setArcHeight(25);
        Building63.setArcWidth(25);
        Building63.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 4
        
        Rectangle Building64 = new Rectangle(890, 280, 35, 35);
        Building64.setArcHeight(25);
        Building64.setArcWidth(25);
        Building64.setHeight(35);
        Building64.setWidth(70);
        Building64.setFill(Color.BLUE);
        
        
        Rectangle Building65 = new Rectangle(980, 280, 35, 35);
        Building65.setArcHeight(25);
        Building65.setArcWidth(25);
        Building65.setHeight(35);
        Building65.setWidth(70);
        Building65.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 5
        Rectangle Building66 = new Rectangle(50, 345, 35, 35);
        Building66.setArcHeight(25);
        Building66.setArcWidth(25);
        Building66.setFill(Color.BLUE);

        
        Rectangle Building67 = new Rectangle(125, 345, 35, 35);
        Building67.setArcHeight(25);
        Building67.setArcWidth(25);
        Building67.setFill(Color.BLUE);
        
        Rectangle Building68 = new Rectangle(200, 345, 35, 35);
        Building68.setArcHeight(25);
        Building68.setArcWidth(25);
        Building68.setFill(Color.BLUE);
        
        Rectangle Building69 = new Rectangle(270, 345, 35, 35);
        Building69.setArcHeight(25);
        Building69.setArcWidth(25);
        Building69.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 6
        
        Rectangle Building70 = new Rectangle(370, 345, 35, 35);
        Building70.setArcHeight(25);
        Building70.setArcWidth(25);
        Building70.setFill(Color.BLUE);
        
        Rectangle Building71 = new Rectangle(460, 345, 35, 35);
        Building71.setArcHeight(25);
        Building71.setArcWidth(25);
        Building71.setFill(Color.BLUE);
        
        Rectangle Building72 = new Rectangle(540, 345, 35, 35);
        Building72.setArcHeight(25);
        Building72.setArcWidth(25);
        Building72.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 7
        
        Rectangle Building73 = new Rectangle(630, 345, 35, 35);
        Building73.setArcHeight(25);
        Building73.setArcWidth(25);
        Building73.setFill(Color.BLUE);
        
        
        Rectangle Building74 = new Rectangle(690, 345, 35, 35);
        Building74.setArcHeight(25);
        Building74.setArcWidth(25);
        Building74.setFill(Color.BLUE);
        
        Rectangle Building75 = new Rectangle(750, 345, 35, 35);
        Building75.setArcHeight(25);
        Building75.setArcWidth(25);
        Building75.setFill(Color.BLUE);
        
        Rectangle Building76 = new Rectangle(810, 345, 35, 35);
        Building76.setArcHeight(25);
        Building76.setArcWidth(25);
        Building76.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 8
        
        Rectangle Building77 = new Rectangle(880, 345, 35, 35);
        Building77.setArcHeight(25);
        Building77.setArcWidth(25);
        Building77.setFill(Color.BLUE);
        
        Rectangle Building78 = new Rectangle(950, 345, 35, 35);
        Building78.setArcHeight(25);
        Building78.setArcWidth(25);
        Building78.setFill(Color.BLUE);
        
        Rectangle Building79 = new Rectangle(1010, 345, 35, 35);
        Building79.setArcHeight(25);
        Building79.setArcWidth(25);
        Building79.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 9
        Rectangle Building80 = new Rectangle(50, 410, 35, 35);
        Building80.setArcHeight(25);
        Building80.setArcWidth(25);
        Building80.setFill(Color.BLUE);
        
        Rectangle Building81 = new Rectangle(165, 410, 35, 35);
        Building81.setArcHeight(25);
        Building81.setArcWidth(25);
        Building81.setFill(Color.BLUE);
        
        
        
        Rectangle Building82 = new Rectangle(270, 410, 35, 35);
        Building82.setArcHeight(25);
        Building82.setArcWidth(25);
        Building82.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 10 
        Rectangle Building83 = new Rectangle(350, 410, 35, 35);
        Building83.setArcHeight(25);
        Building83.setArcWidth(25);
        Building83.setFill(Color.BLUE);
        
        Rectangle Building84 = new Rectangle(425, 410, 35, 35);
        Building84.setArcHeight(25);
        Building84.setArcWidth(25);
        Building84.setFill(Color.BLUE);
        
        Rectangle Building85 = new Rectangle(490, 410, 35, 35);
        Building85.setArcHeight(25);
        Building85.setArcWidth(25);
        Building85.setFill(Color.BLUE);
        
        
        Rectangle Building86 = new Rectangle(550, 410, 35, 35);
        Building86.setArcHeight(25);
        Building86.setArcWidth(25);
        Building86.setFill(Color.BLUE);
        
        // Neighbourhood_2 : BLOCK 11
        Rectangle Building87 = new Rectangle(640, 410, 35, 35);
        Building87.setArcHeight(25);
        Building87.setArcWidth(25);
        Building87.setHeight(35);
        Building87.setWidth(80);
        Building87.setFill(Color.BLUE);
        
        Rectangle Building88 = new Rectangle(760, 410, 35, 35);
        Building88.setArcHeight(25);
        Building88.setArcWidth(25);
        Building88.setHeight(35);
        Building88.setWidth(80);
        Building88.setFill(Color.BLUE);
        
        
        // Neighbourhood_2 : BLOCK 12 
        Rectangle Building89 = new Rectangle(880, 410, 35, 35);
        Building89.setArcHeight(25);
        Building89.setArcWidth(25);
        Building89.setFill(Color.BLUE);
        
        
        Rectangle Building90 = new Rectangle(950, 410, 35, 35);
        Building90.setArcHeight(25);
        Building90.setArcWidth(25);
        Building90.setFill(Color.BLUE);
        
        Rectangle Building91 = new Rectangle(1010, 410, 35, 35);
        Building91.setArcHeight(25);
        Building91.setArcWidth(25);
        Building91.setFill(Color.BLUE);
        
        // Neighbourhood 3 ( from Building 92 to Building 133  ) with 12 blocks include Warehouse :
        
        // Neighbourhood_3 : BLOCK 1
        Rectangle Building92 = new Rectangle(50, 475, 35, 35);
        Building92.setArcHeight(25);
        Building92.setArcWidth(25);
        Building92.setFill(Color.web("#C0392B"));
        
        Rectangle Building93 = new Rectangle(125, 475, 35, 35);
        Building93.setArcHeight(25);
        Building93.setArcWidth(25);
        Building93.setFill(Color.web("#C0392B"));
        
        Rectangle Building94 = new Rectangle(200, 475, 35, 35);
        Building94.setArcHeight(25);
        Building94.setArcWidth(25);
        Building94.setFill(Color.web("#C0392B"));
        
        Rectangle Building95 = new Rectangle(270, 475, 35, 35);
        Building95.setArcHeight(25);
        Building95.setArcWidth(25);
        Building95.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 2
        Rectangle Building96 = new Rectangle(370, 475, 35, 35);
        Building96.setArcHeight(25);
        Building96.setArcWidth(25);
        Building96.setFill(Color.web("#C0392B"));
        
        Rectangle Building97 = new Rectangle(460, 475, 35, 35);
        Building97.setArcHeight(25);
        Building97.setArcWidth(25);
        Building97.setFill(Color.web("#C0392B"));
        
        
        Rectangle Building98 = new Rectangle(540, 475, 35, 35);
        Building98.setArcHeight(25);
        Building98.setArcWidth(25);
        Building98.setFill(Color.web("#C0392B"));
        
        
        // Neighbourhood_3 : BLOCK 3
        Rectangle Building99 = new Rectangle(630, 475, 35, 35);
        Building99.setArcHeight(25);
        Building99.setArcWidth(25);
        Building99.setFill(Color.web("#C0392B"));
        
        Rectangle Building100 = new Rectangle(690, 475, 35, 35);
        Building100.setArcHeight(25);
        Building100.setArcWidth(25);
        Building100.setFill(Color.web("#C0392B"));
        
        Rectangle Building101 = new Rectangle(750, 475, 35, 35);
        Building101.setArcHeight(25);
        Building101.setArcWidth(25);
        Building101.setFill(Color.web("#C0392B"));
        
        Rectangle Building102 = new Rectangle(810, 475, 35, 35);
        Building102.setArcHeight(25);
        Building102.setArcWidth(25);
        Building102.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 4
        Rectangle Building103 = new Rectangle(890, 475, 35, 35);
        Building103.setArcHeight(25);
        Building103.setArcWidth(25);
        Building103.setFill(Color.web("#C0392B"));
        
        Rectangle Building104 = new Rectangle(960, 475, 35, 35);
        Building104.setArcHeight(25);
        Building104.setArcWidth(25);
        Building104.setFill(Color.web("#C0392B"));
        
        Rectangle Building105 = new Rectangle(1020, 475, 35, 35);
        Building105.setArcHeight(25);
        Building105.setArcWidth(25);
        Building105.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 5
        Rectangle Building106 = new Rectangle(50, 540, 35, 35);
        Building106.setArcHeight(25);
        Building106.setArcWidth(25);
        Building106.setFill(Color.web("#C0392B"));
        
        Rectangle Building107 = new Rectangle(125, 540, 35, 35);
        Building107.setArcHeight(25);
        Building107.setArcWidth(25);
        Building107.setFill(Color.web("#C0392B"));
        
        
        Rectangle Building108 = new Rectangle(200, 540, 35, 35);
        Building108.setArcHeight(25);
        Building108.setArcWidth(25);
        Building108.setFill(Color.web("#C0392B"));
        
        Rectangle Building109 = new Rectangle(270, 540, 35, 35);
        Building109.setArcHeight(25);
        Building109.setArcWidth(25);
        Building109.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 6
        Rectangle Building110 = new Rectangle(355, 540, 35, 35);
        Building110.setArcHeight(25);
        Building110.setArcWidth(25);
        Building110.setFill(Color.web("#C0392B"));
        
        Rectangle Building111 = new Rectangle(425, 540, 35, 35);
        Building111.setArcHeight(25);
        Building111.setArcWidth(25);
        Building111.setFill(Color.web("#C0392B"));
        
        Rectangle Building112 = new Rectangle(490, 540, 35, 35);
        Building112.setArcHeight(25);
        Building112.setArcWidth(25);
        Building112.setFill(Color.web("#C0392B"));
        
        Rectangle Building113 = new Rectangle(550, 540, 35, 35);
        Building113.setArcHeight(25);
        Building113.setArcWidth(25);
        Building113.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 7
        
        Rectangle Building114 = new Rectangle(640, 540, 35, 35);
        Building114.setArcHeight(25);
        Building114.setArcWidth(25);
        Building114.setFill(Color.web("#C0392B"));
        
        
        Rectangle Building115 = new Rectangle(720, 540, 35, 35);
        Building115.setArcHeight(25);
        Building115.setArcWidth(25);
        Building115.setFill(Color.web("#C0392B"));

        Rectangle Building116 = new Rectangle(800, 540, 35, 35);
        Building116.setArcHeight(25);
        Building116.setArcWidth(25);
        Building116.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 8
        
        Rectangle Building117 = new Rectangle(890, 540, 35, 35);
        Building117.setArcHeight(25);
        Building117.setArcWidth(25);
        Building117.setFill(Color.web("#C0392B"));
        
        Rectangle Building118 = new Rectangle(955, 540, 35, 35);
        Building118.setArcHeight(25);
        Building118.setArcWidth(25);
        Building118.setFill(Color.web("#C0392B"));
        
        Rectangle Building119 = new Rectangle(1015, 540, 35, 35);
        Building119.setArcHeight(25);
        Building119.setArcWidth(25);
        Building119.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 9 for "Warehouse , which take Building from 120 to 123 "
        Text Warehouse_label = new Text(100,645,"Warehouse");
        Warehouse_label.setFont(font);
        Warehouse_label.setFill(Color.BLACK);
        Rectangle Warehouse = new Rectangle(45, 600, 35, 35);
        Warehouse.setArcHeight(25);
        Warehouse.setArcWidth(25);
        Warehouse.setWidth(280);
        Warehouse.setHeight(75);
        Warehouse.setFill(Color.SILVER);
         Tooltip tooltipWareHouseBuilding = new Tooltip("Initial Position: Warehouse");
        Tooltip.install(Warehouse, tooltipWareHouseBuilding); 
        Warehouse.setOnMouseEntered(event -> {
            // Show the tooltip only if the mouse is within the building bounds
            if (Warehouse.contains(event.getX(), event.getY())) {
                tooltipWareHouseBuilding.show(Warehouse, event.getScreenX(), event.getScreenY() + 20);
            }
        });
        
        Warehouse.setOnMouseExited(event -> {
            // Hide the tooltip
            tooltipWareHouseBuilding.hide();
        });
        
        // Neighbourhood_3 : BLOCK 10 
        Rectangle Building120 = new Rectangle(350, 605, 35, 35);
        Building120.setArcHeight(25);
        Building120.setArcWidth(25);
        Building120.setFill(Color.web("#C0392B"));
        
        
        Rectangle Building121 = new Rectangle(425, 605, 35, 35);
        Building121.setArcHeight(25);
        Building121.setArcWidth(25);
        Building121.setFill(Color.web("#C0392B"));
        
        Rectangle Building122 = new Rectangle(490, 605, 35, 35);
        Building122.setArcHeight(25);
        Building122.setArcWidth(25);
        Building122.setFill(Color.web("#C0392B"));

        Rectangle Building123 = new Rectangle(550, 605, 35, 35);
        Building123.setArcHeight(25);
        Building123.setArcWidth(25);
        Building123.setFill(Color.web("#C0392B"));

        // Neighbourhood_3 : BLOCK 11
        Rectangle Building124 = new Rectangle(635, 605, 35, 35);
        Building124.setArcHeight(25);
        Building124.setArcWidth(25);
        Building124.setFill(Color.web("#C0392B"));
        
        Rectangle Building125 = new Rectangle(710, 605, 35, 35);
        Building125.setArcHeight(25);
        Building125.setArcWidth(25);
        Building125.setFill(Color.web("#C0392B"));
        
        Rectangle Building126 = new Rectangle(785, 605, 35, 35);
        Building126.setArcHeight(25);
        Building126.setArcWidth(25);
        Building126.setFill(Color.web("#C0392B"));
        
        // Neighbourhood_3 : BLOCK 12
        Rectangle Building127 = new Rectangle(880, 605, 35, 35);
        Building127.setArcHeight(25);
        Building127.setArcWidth(25);
        Building127.setFill(Color.web("#C0392B"));
        
        Rectangle Building128 = new Rectangle(945, 605, 35, 35);
        Building128.setArcHeight(25);
        Building128.setArcWidth(25);
        Building128.setFill(Color.web("#C0392B"));
        
        Rectangle Building129 = new Rectangle(1010, 605, 35, 35);
        Building129.setArcHeight(25);
        Building129.setArcWidth(25);
        Building129.setFill(Color.web("#C0392B"));
        

        Text Street_1Lable = new Text(25, 73, "1");
        Street_1Lable.setFont(font);
        Street_1Lable.setFill(Color.BLACK);
 
        Text Street_2Lable = new Text(25, 137, "2");
        Street_2Lable.setFont(font);
        Street_2Lable.setFill(Color.BLACK); 
        
        Text Street_3Lable = new Text(25, 204, "3");
        Street_3Lable.setFont(font);
        Street_3Lable.setFill(Color.BLACK);
        
        Text Street_4Lable = new Text(25, 272, "4");
        Street_4Lable.setFont(font);
        Street_4Lable.setFill(Color.BLACK);
        
        Text Street_5Lable = new Text(25, 337, "5");
        Street_5Lable.setFont(font);
        Street_5Lable.setFill(Color.BLACK);
        
        Text Street_6Lable = new Text(25, 402, "6");
        Street_6Lable.setFont(font);    
        Street_6Lable.setFill(Color.BLACK);
        
        Text Street_7Lable = new Text(25, 468, "7");
        Street_7Lable.setFont(font);
        Street_7Lable.setFill(Color.BLACK);
        
        Text Street_8Lable = new Text(25, 534, "8");
        Street_8Lable.setFont(font);    
        Street_8Lable.setFill(Color.BLACK);
        
        Text Street_9Lable = new Text(25,601, "9");
        Street_9Lable.setFont(font);
        Street_9Lable.setFill(Color.BLACK);
        
        

        Text Street_ALable = new Text(322, 678, "A");
        Street_ALable.setFont(font );
        Street_ALable.setFill(Color.BLACK);

        Text Street_BLable = new Text(592, 678, "B");
        Street_BLable.setFont(font );
        Street_BLable.setFill(Color.BLACK);

        Text Street_CLable = new Text(851, 678, "C");
        Street_CLable.setFont(font );
        Street_CLable.setFill(Color.BLACK);
        Group neighborhoodsGroup = new Group();
        // Add homes to Neighborhood 1 group
        
        Group neighborhood1Group = new Group();
        neighborhood1Group.getChildren().addAll( Building1 ,Building2 , Building3 , Building4 ,Building5,Building6,Building7,Building8,Building9,Building10,Building11,Building12,Building13,Building14,Building15,Building16,Building17,Building18,Building19,Building20,Building21,Building22,Building23,Building24,Building25,Building26,Building27,Building28,Building29,Building30,Building31,Building32,Building33,Building34,Building35,Building36,Building37,Building38,Building39,Building40,Building41,Building42,Building43,Building44,Building45,Building46,Building47,Building48,Building49,Building50,Building51,Building52);
        
        // Add homes to Neighborhood 2 group
        Group neighborhood2Group = new Group();
        neighborhood2Group.getChildren().addAll(Building53,Building54,Building55,Building56,Building57,Building58,Building59,Building60,Building61,Building62,Building63,Building64,Building65,Building66,Building67,Building68,Building69,Building70,Building71,Building72,Building73,Building74,Building75,Building76,Building77,Building78,Building79,Building80,Building81,Building82,Building83,Building84,Building85,Building86,Building87,Building88,Building89,Building90,Building91);
        
        // Add homes to Neighborhood 3 group
        
        Group neighborhood3Group = new Group();
        neighborhood3Group.getChildren().addAll(Building92,Building93,Building94,Building95,Building96,Building97,Building98,Building99,Building100,Building101,Building102,Building103,Building104,Building105,Building106,Building107,Building108,Building109,Building110,Building111,Building112,Building113,Building114,Building115,Building116,Building117,Building118,Building119,Warehouse,Warehouse_label,Building120,Building121,Building122,Building123,Building124,Building125,Building126,Building127,Building128,Building129);

        Group warehousesGroup = new Group();
        warehousesGroup.getChildren().addAll(Warehouse, Warehouse_label);
        buildings= Arrays.asList(Building1 ,Building2 , Building3 , Building4 ,Building5,Building6,Building7,Building8,Building9,Building10,Building11,Building12,Building13,Building14,Building15,Building16,Building17,Building18,Building19,Building20,Building21,Building22,Building23,Building24,Building25,Building26,Building27,Building28,Building29,Building30,Building31,Building32,Building33,Building34,Building35,Building36,Building37,Building38,Building39,Building40,Building41,Building42,Building43,Building44,Building45,Building46,Building47,Building48,Building49,Building50,Building51,Building52,Building53,Building54,Building55,Building56,Building57,Building58,Building59,Building60,Building61,Building62,Building63,Building64,Building65,Building66,Building67,Building68,Building69,Building70,Building71,Building72,Building73,Building74,Building75,Building76,Building77,Building78,Building79,Building80,Building81,Building82,Building83,Building84,Building85,Building86,Building87,Building88,Building89,Building90,Building91,Building92,Building93,Building94,Building95,Building96,Building97,Building98,Building99,Building100,Building101,Building102,Building103,Building104,Building105,Building106,Building107,Building108,Building109,Building110,Building111,Building112,Building113,Building114,Building115,Building116,Building117,Building118,Building119,Building120,Building121,Building122,Building123,Building124,Building125,Building126,Building127,Building128,Building129);
        neighborhoodsGroup.getChildren().addAll(Street_CLable,Street_BLable,Street_ALable,Street_1Lable,Street_2Lable,Street_3Lable,Street_4Lable,Street_5Lable,Street_6Lable,Street_7Lable,Street_8Lable,Street_9Lable,neighborhood1Group,neighborhood2Group,neighborhood3Group,warehousesGroup);
        AllGroups.getChildren().add(neighborhoodsGroup);
    }

    public void streets(Pane AllGroups) {
    
        // ------------------STREETS-----------------------    
            // Streets for Alhamdaniyah Neighourhood: 
            
        Line Street_1 = new Line(0, 0, 1000, 0);
        Street_1.setStrokeWidth(12);
        Street_1.setTranslateX(50);
        Street_1.setTranslateY(66);
        
            Line Street_2 = new Line(0, 0, 1000, 0);
        Street_2.setStrokeWidth(12);
        Street_2.setTranslateX(50);
        Street_2.setTranslateY(132);
        
        
        Line Street_3 = new Line(0, 0, 1000, 0);
        Street_3.setStrokeWidth(12);
        Street_3.setTranslateX(50);
        Street_3.setTranslateY(198);
        
        //Streets for AlManar Neighourhood:
        
        Line Street_4 = new Line(0, 0, 1000, 0);
        Street_4.setStrokeWidth(12);
        Street_4.setTranslateX(50);
        Street_4.setTranslateY(264);
        
        
        
        Line Street_5 = new Line(0, 0, 1000, 0);
        Street_5.setStrokeWidth(12);
        Street_5.setTranslateX(50);
        Street_5.setTranslateY(330);
        
        
        Line Street_6 = new Line(0, 0, 1000, 0);
        Street_6.setStrokeWidth(12);
        Street_6.setTranslateX(50);
        Street_6.setTranslateY(396);
        
        //Streets for AlRabwah Neighourhood: 
        
        Line Street_7 = new Line(0, 0, 1000, 0);
        Street_7.setStrokeWidth(12);
        Street_7.setTranslateX(50);
        Street_7.setTranslateY(462);
        
        
        Line Street_8 = new Line(0, 0, 1000, 0);
        Street_8.setStrokeWidth(12);
        Street_8.setTranslateX(50);
        Street_8.setTranslateY(528);
        
        
        Line Street_9 = new Line(0, 0, 1000, 0);
        Street_9.setStrokeWidth(12);
        Street_9.setTranslateX(50);
        Street_9.setTranslateY(594);
        
        
        //STREET A: 
        
        Line Street_A = new Line(0, 0, 0, 650);
        Street_A.setStrokeWidth(12);
        Street_A.setTranslateX(330);
        Street_A.setTranslateY(0);
        
        // White line inside street A

        Line line_street_white1 = new Line(0, 0, 0, 650);
        line_street_white1.setStrokeWidth(12);
        line_street_white1.setStroke(Color.BLUE);
        line_street_white1.setTranslateX(330);
        line_street_white1.setTranslateY(0); 
        
        
        // STREET B :
        Line Street_B = new Line(0, 0, 0, 650);
        Street_B.setStrokeWidth(12);
        Street_B.setTranslateX(600);
        Street_B.setTranslateY(0);
        
        
        // STREET C: 
        Line Street_C = new Line(0, 0, 0, 650);
        Street_C.setStrokeWidth(12);
        Street_C.setTranslateX(860);
        Street_C.setTranslateY(0);
        
        
            // Create a group for streets
        Group streetsGroup = new Group();
        streetsGroup.getChildren().addAll(Street_1, Street_2, Street_3, Street_4, Street_5,
                        Street_6,Street_7,line_street_white1,Street_8,Street_9,Street_A , 
                        Street_B,Street_C);
        
        AllGroups.getChildren().add(streetsGroup);
    
    
    }

    public void Labels (Pane AllGroups, Boolean isPhase1Selected) {
        // For Time : 
        Rectangle timerRectangle = new Rectangle(1080,65,80, 40);
        timerRectangle.setStroke(Color.web("#000C40"));
        timerRectangle.setStrokeWidth(5);
        timerRectangle.setFill(Color.web("#F0F2F0"));
        
        // For Distance : 
        Rectangle distanceRectangle = new Rectangle(1190,65,80, 40);
        distanceRectangle.setStroke(Color.web("#000C40"));
        distanceRectangle.setStrokeWidth(5);
        distanceRectangle.setFill(Color.web("#F0F2F0"));
        
        // For Cost : 
        Rectangle costRectangle = new Rectangle(1080,130,75, 40);
        costRectangle.setStroke(Color.web("#000C40"));
        costRectangle.setStrokeWidth(5);
        costRectangle.setFill(Color.web("#F0F2F0"));
        
        
        // For No.Simulations : 
        Rectangle No_SimulationRectangle = new Rectangle(1190,130,80, 40);
        No_SimulationRectangle.setStroke(Color.web("#000C40"));
        No_SimulationRectangle.setStrokeWidth(5);
        No_SimulationRectangle.setFill(Color.web("#F0F2F0"));
  
        // For Time : 
        Font Labelfont = new Font(" Times New Roman",13);
        Label timeLabel = new Label("Time");
        timeLabel.setFont(Labelfont);
        timeLabel.setLayoutX(1100);
        timeLabel.setLayoutY(45);
        timeLabel.setStyle("-fx-text-fill: #F0F2F0;");
        
        // For Distance :
        Label distanceLabel = new Label("Distance");
        distanceLabel.setFont(Labelfont);
        distanceLabel.setLayoutX(1200);
        distanceLabel.setLayoutY(45);
        distanceLabel.setStyle("-fx-text-fill: #F0F2F0;");
        
        // For Cost :
        Label costLabel = new Label("Cost of gasoline");
        costLabel.setFont(Labelfont);
        costLabel.setLayoutX(1075);
        costLabel.setLayoutY(110);
        costLabel.setStyle("-fx-text-fill: #F0F2F0;");

        
        
        // For No_Simulations :
        Label No_SimulationLabel = new Label("Number of Simulations");
        No_SimulationLabel.setFont(Labelfont);
        No_SimulationLabel.setLayoutX(1190);
        No_SimulationLabel.setLayoutY(110);
        No_SimulationLabel.setStyle("-fx-text-fill: #F0F2F0;");
        
        // Time,distance and cost Counter Labels :
        
        // For Time : 
        
        Font CounterLabelfont = new Font(" Times New Roman",15);
        CounterTimeLabel = new Label("00:00:00");
        CounterTimeLabel.setFont(CounterLabelfont);
        CounterTimeLabel.setTextFill(Color.web("#000C40"));
        CounterTimeLabel.setLayoutX(1090);
        CounterTimeLabel.setLayoutY(75);
        
        // For Distance :
        
        CounterDistanceLabel = new Label("00.00 Km");
        CounterDistanceLabel.setFont(CounterLabelfont);
        CounterDistanceLabel.setTextFill(Color.web("#000C40"));        
        CounterDistanceLabel.setLayoutX(1200);
        CounterDistanceLabel.setLayoutY(75);
        
        // For Cost :

        Font CounterCostfont = new Font(" Times New Roman",13);
        CounterCostLabel = new Label(" SAR 00,00");
        CounterCostLabel.setFont(CounterCostfont);
        CounterCostLabel.setTextFill(Color.web("#000C40"));
        CounterCostLabel.setLayoutX(1082);
        CounterCostLabel.setLayoutY(140);
        
        // For No_Simulations:
        
        CounterNo_SimulationLabel = new Label("0");
        CounterNo_SimulationLabel.setFont(CounterLabelfont);
        CounterNo_SimulationLabel.setTextFill(Color.web("#000C40"));
        CounterNo_SimulationLabel.setLayoutX(1225);
        CounterNo_SimulationLabel.setLayoutY(140);

        percentLabelP2 = new Label("00.00%");
        percentLabelP2.setFont(CounterLabelfont);
        percentLabelP2.setTextFill(Color.web("#000C40"));
        percentLabelP2.setLayoutX(1095);
        percentLabelP2.setLayoutY(205);

        Rectangle percentRectangle = new Rectangle(1075,195,80, 40);
        percentRectangle.setStroke(Color.web("#000C40"));
        percentRectangle.setStrokeWidth(5);
        percentRectangle.setFill(Color.web("#F0F2F0"));

        Font Labelfont_forpercent = new Font(" Times New Roman",12);
        
        Label percent_LabelP2 = new Label("Percent Improvement");
        percent_LabelP2.setFont(Labelfont_forpercent);
        percent_LabelP2.setLayoutX(1070);
        percent_LabelP2.setLayoutY(175);
        percent_LabelP2.setStyle("-fx-text-fill: #F0F2F0;");

        Font Labelfont_forphase2in1 = new Font(" Times New Roman",13);
        
        Rectangle Ideal_rectangle = new Rectangle(1190,195,80, 40);
        Ideal_rectangle.setStroke(Color.web("#000C40"));
        Ideal_rectangle.setStrokeWidth(5);
        Ideal_rectangle.setFill(Color.web("#F0F2F0"));
        
        Label Ideal_rectangle_lable = new Label("Ideal time");
        Ideal_rectangle_lable.setFont(Labelfont_forphase2in1);
        Ideal_rectangle_lable.setLayoutX(1200);
        Ideal_rectangle_lable.setLayoutY(175);
        Ideal_rectangle_lable.setStyle("-fx-text-fill: #F0F2F0;");
        
        Label Ideal_rectangle_lableBox = new Label("1:30:00");
        Ideal_rectangle_lableBox.setFont(CounterLabelfont);
        Ideal_rectangle_lableBox.setTextFill(Color.web("#000C40"));        
        Ideal_rectangle_lableBox.setLayoutX(1210);
        Ideal_rectangle_lableBox.setLayoutY(205);
    
        
        //Rectangle TIME PHASE 1 IN 2
        
        Label Nmae_of_phase1In2 = new Label("INFORMATION PHASE 1");
        Nmae_of_phase1In2.setFont(Labelfont_forphase2in1);
        Nmae_of_phase1In2.setLayoutX(1135);
        Nmae_of_phase1In2.setLayoutY(270);
        Nmae_of_phase1In2.setStyle("-fx-text-fill: #F0F2F0;");
        
        Rectangle time_phase1_in2 = new Rectangle(1100,300,220, 95);
        time_phase1_in2.setStroke(Color.web("#000C40"));
        time_phase1_in2.setStrokeWidth(5);
        time_phase1_in2.setFill(Color.web("#F0F2F0"));
        
        Label time_phase1_in2_lable = new Label("TIME");
        time_phase1_in2_lable.setFont(Labelfont_forphase2in1);
        time_phase1_in2_lable.setLayoutX(1275);
        time_phase1_in2_lable.setLayoutY(310);
        time_phase1_in2_lable.setStyle("-fx-text-fill: #000C40;");
        
        CountertimeLabe1_phase1_to_2 = new Label("00:00");
        CountertimeLabe1_phase1_to_2.setFont(Labelfont_forphase2in1);
        CountertimeLabe1_phase1_to_2.setTextFill(Color.web("#000C40"));        
        CountertimeLabe1_phase1_to_2.setLayoutX(1265);
        CountertimeLabe1_phase1_to_2.setLayoutY(350);
        
        
        //Rectangle DISTANCE PHASE 1 IN 2
       
        Label distance_phase1_in2_lable = new Label("Distance");
        distance_phase1_in2_lable.setFont(Labelfont_forphase2in1);
        distance_phase1_in2_lable.setLayoutX(1110);
        distance_phase1_in2_lable.setLayoutY(310);
        distance_phase1_in2_lable.setStyle("-fx-text-fill: #000C40;");
        
        CounterDistanceLabe1_phase1_to_2 = new Label("00:00 KM");
        CounterDistanceLabe1_phase1_to_2.setFont(Labelfont_forphase2in1);
        CounterDistanceLabe1_phase1_to_2.setTextFill(Color.web("#000C40"));        
        CounterDistanceLabe1_phase1_to_2.setLayoutX(1105);
        CounterDistanceLabe1_phase1_to_2.setLayoutY(350);
        
        //Rectangle GASOLIN PHASE 1 IN 2
        
        Label gasolin_phase1_in2_lable = new Label("GASOLIN");
        gasolin_phase1_in2_lable.setFont(Labelfont_forphase2in1);
        gasolin_phase1_in2_lable.setLayoutX(1185);
        gasolin_phase1_in2_lable.setLayoutY(310);
        gasolin_phase1_in2_lable.setStyle("-fx-text-fill: #000C40;");
        
        CounterGasolinLabe1_phase1_to_2 = new Label("00:00 SAR");
        CounterGasolinLabe1_phase1_to_2.setFont(Labelfont_forphase2in1);
        CounterGasolinLabe1_phase1_to_2.setTextFill(Color.web("#000C40"));        
        CounterGasolinLabe1_phase1_to_2.setLayoutX(1180);
        CounterGasolinLabe1_phase1_to_2.setLayoutY(350);
        
        Line line_of_phase1In2 = new Line();

        line_of_phase1In2.setStartX(1170); 
        line_of_phase1In2.setStartY(305); 

        line_of_phase1In2.setEndX(1170); 
        line_of_phase1In2.setEndY(390); 

        line_of_phase1In2.setStrokeWidth(4); 
        line_of_phase1In2.setStroke(Color.BLACK); 
        
        Line line_of_phase1In22 = new Line();

        line_of_phase1In22.setStartX(1255); 
        line_of_phase1In22.setStartY(305); 

        line_of_phase1In22.setEndX(1255); 
        line_of_phase1In22.setEndY(390); 

        line_of_phase1In22.setStrokeWidth(4); 
        line_of_phase1In22.setStroke(Color.BLACK); 
        
        Label Nmae_INFORMATION_KEY = new Label("INFORMATION KEY MAP");
        Nmae_INFORMATION_KEY.setFont(Labelfont_forphase2in1);
        Nmae_INFORMATION_KEY.setLayoutX(1135);
        Nmae_INFORMATION_KEY.setLayoutY(420);
        Nmae_INFORMATION_KEY.setStyle("-fx-text-fill: #F0F2F0;");
        
        Rectangle INFORMATION_KEY= new Rectangle(1100,450,220, 140);
        INFORMATION_KEY.setStroke(Color.web("#000C40"));
        INFORMATION_KEY.setStrokeWidth(5);
        INFORMATION_KEY.setFill(Color.web("#F0F2F0"));
        
        Font Labelfont_map = new Font(" Times New Roman",16);

        
        Label NAME_OF_Alhamdaniya = new Label("AlHAMDANIYA");
        NAME_OF_Alhamdaniya.setFont(Labelfont_map);
        NAME_OF_Alhamdaniya.setLayoutX(1110);
        NAME_OF_Alhamdaniya.setLayoutY(455);
        NAME_OF_Alhamdaniya.setStyle("-fx-text-fill: #808080;");
        
        Rectangle rec_Alhamdaniya = new Rectangle(1250, 455, 30, 30);
        rec_Alhamdaniya.setArcHeight(25);
        rec_Alhamdaniya.setArcWidth(25);
        rec_Alhamdaniya.setHeight(25);
        rec_Alhamdaniya.setWidth(60);
        rec_Alhamdaniya.setFill(Color.GREY);
        
        Label NAME_OF_Almanar = new Label("AlMANAR");
        NAME_OF_Almanar.setFont(Labelfont_map);
        NAME_OF_Almanar.setLayoutX(1110);
        NAME_OF_Almanar.setLayoutY(490);
        NAME_OF_Almanar.setStyle("-fx-text-fill: blue;");
        
        Rectangle rec_Almanar = new Rectangle(1250, 490, 30, 30);
        rec_Almanar.setArcHeight(25);
        rec_Almanar.setArcWidth(25);
        rec_Almanar.setHeight(25);
        rec_Almanar.setWidth(60);
        rec_Almanar.setFill(Color.BLUE);
        
        Label NAME_OF_AlRabwah = new Label("AlRABWAH");
        NAME_OF_AlRabwah.setFont(Labelfont_map);
        NAME_OF_AlRabwah.setLayoutX(1110);
        NAME_OF_AlRabwah.setLayoutY(525);
        NAME_OF_AlRabwah.setStyle("-fx-text-fill: #C0392B ;"); 
        
        Rectangle rec_AlRabwah = new Rectangle(1250, 525, 30, 30);
        rec_AlRabwah.setArcHeight(25);
        rec_AlRabwah.setArcWidth(25);
        rec_AlRabwah.setHeight(25);
        rec_AlRabwah.setWidth(60);
        rec_AlRabwah.setFill(Color.web("#C0392B"));
        
        Label Name_house_green = new Label("HOUSE DELIVERED");
        Name_house_green.setFont(Labelfont_map);
        Name_house_green.setLayoutX(1110);
        Name_house_green.setLayoutY(555);
        Name_house_green.setStyle("-fx-text-fill: GREEN ;"); 
        
        Rectangle rec_house_green = new Rectangle(1250, 555, 30, 30);
        rec_house_green.setArcHeight(25);
        rec_house_green.setArcWidth(25);
        rec_house_green.setHeight(25);
        rec_house_green.setWidth(60);
        rec_house_green.setFill(Color.web("GREEN"));
        
         Group labelsGroup = new Group();
            labelsGroup.getChildren().addAll( Ideal_rectangle,Ideal_rectangle_lable , Ideal_rectangle_lableBox ,timeLabel, distanceLabel,costLabel,No_SimulationLabel,timerRectangle,distanceRectangle,costRectangle,No_SimulationRectangle,Nmae_INFORMATION_KEY , INFORMATION_KEY , NAME_OF_Alhamdaniya , rec_Alhamdaniya , NAME_OF_Almanar , rec_Almanar,NAME_OF_AlRabwah , rec_AlRabwah
            , Name_house_green , rec_house_green);
            Group counterLabelsGroup = new Group();
                counterLabelsGroup.getChildren().addAll( CounterTimeLabel, CounterDistanceLabel,CounterCostLabel,CounterNo_SimulationLabel);
            Group percentLabelsGroup = new Group(); 
            percentLabelsGroup.getChildren().addAll(percent_LabelP2,percentRectangle,percentLabelP2,Nmae_of_phase1In2 ,
            time_phase1_in2 ,time_phase1_in2_lable ,CountertimeLabe1_phase1_to_2, 
              distance_phase1_in2_lable ,CounterDistanceLabe1_phase1_to_2, 
            gasolin_phase1_in2_lable ,CounterGasolinLabe1_phase1_to_2 , line_of_phase1In2 , line_of_phase1In22);
            if (FirstPage.isPhase2Selected) {
                AllGroups.getChildren().addAll(labelsGroup,counterLabelsGroup,percentLabelsGroup);
            }       
            else{
                AllGroups.getChildren().remove(percentLabelsGroup);
                AllGroups.getChildren().addAll(labelsGroup,counterLabelsGroup);

            }          
    }

    public void Buttons (Pane AllGroups,Stage primaryStage) {
        Button Start_button = new Button();
        Start_button.setPrefSize(60, 20);
        Start_button.setLayoutX(1050);
        Start_button.setLayoutY(15);

        Image Starticon = new Image(getClass().getResourceAsStream("StartButton.png"));
        ImageView iconView = new ImageView(Starticon);
        iconView.setFitWidth(30);
        iconView.setFitHeight(15);

        Start_button.setGraphic(iconView);
        Start_button.setStyle( "-fx-background-color: #F0F2F0; " );
        Start_button.setContentDisplay(ContentDisplay.CENTER);
        
        Start_button.setOnAction((event) -> {

            
            if (!MainProgram.driver.isTransitionPaused) {
                resetBuildingColors();
                    Platform.runLater(() -> {
                    addToolTipsToAllBuildings();
                    TooltipOfBuildings();
        });
            stopCurrentSimulation();
            MainProgram.initializeChoosenIntersections();
            isStartClicked = true;
            MainProgram.driver.setGasolineCost(0);
            MainProgram.driver.setDistance(0);
            CounterCostLabel.setText(" SAR 00,00");
            CounterDistanceLabel.setText("00.00 Km");
            percentLabelP2.setText("00.00%");
            MainProgram.driver.createPathForPackages(MainProgram.driver.calculateShortestPathsBetweenDestinations(MainProgram.choosenBulding));            
            secondsPassed = 0;
            CounterTimeLabel.setText(formatTime(secondsPassed));
            startSimulation();
            isPaused = false;
            }  
        });
                
        Button Pause_button = new Button();
        Pause_button.setPrefSize(60, 20);
        Pause_button.setLayoutX(1125);
        Pause_button.setLayoutY(15);
        Image Pauseicon = new Image(getClass().getResourceAsStream("PauseButton.png"));
        ImageView iconView2 = new ImageView(Pauseicon);
        iconView2.setFitWidth(30);  
        iconView2.setFitHeight(15);
        Pause_button.setGraphic(iconView2);
        Pause_button.setStyle( "-fx-background-color: #F0F2F0; " );

        Pause_button.setContentDisplay(ContentDisplay.CENTER);
                
        Pause_button.setOnAction(e -> {
        if (!MainProgram.driver.isTransitionPaused) {
            if (isPaused) {
                resumeSimulation();
            } else {
                pauseSimulation();
            }
        }
        });
        
        Button End_button = new Button();
        End_button.setPrefSize(60, 20);
        End_button.setLayoutX(1200);
        End_button.setLayoutY(15);
        Image Endicon = new Image(getClass().getResourceAsStream("EndButton.png"));
        ImageView iconView3 = new ImageView(Endicon);
        iconView3.setFitWidth(30);  
        iconView3.setFitHeight(15); 
        End_button.setGraphic(iconView3);
        End_button.setStyle( "-fx-background-color: #F0F2F0; " );
        End_button.setContentDisplay(ContentDisplay.CENTER);
        
        End_button.setOnAction(e -> {
         if (!MainProgram.driver.isTransitionPaused) {
                endSimulation();
            }
        });
        
        Button Back_button = new Button();
        Back_button.setPrefSize(60, 20);
        Back_button.setLayoutX(1275);
        Back_button.setLayoutY(15);
          Image Backicon = new Image(getClass().getResourceAsStream("BackButton.png"));
        ImageView iconView4 = new ImageView(Backicon);
        iconView4.setFitWidth(30);  
        iconView4.setFitHeight(15); 
        Back_button.setGraphic(iconView4);
        Back_button.setStyle( "-fx-background-color: #F0F2F0; " );
        Back_button.setContentDisplay(ContentDisplay.CENTER);
        
        Back_button.setOnAction(e -> {
                if (!MainProgram.driver.isTransitionPaused){
                numOfSumuolation = 0;
                FirstPage.isPhase1Selected = false;
                FirstPage.isPhase2Selected = false;
        
                openFirstPage();
                restSumaltion();
                carRoutesGroup.getChildren().remove(car);
                primaryStage.hide();
            }
        });

        Group buttonsGroup = new Group ();
        buttonsGroup.getChildren().addAll(Start_button,Pause_button,End_button,Back_button);

        AllGroups.getChildren().add(buttonsGroup);
    }
    

    public double calculatePercentImprovement() {
        

        double percentImprovement = 0.0;

        // Ensure totalTimeP1 isn't zero to avoid division by zero
        if (totalTimeP1 != 0) {
            percentImprovement = (((double) totalTimeP1 - totalTimeP2) / totalTimeP1) * 100;
        } else {
            
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Start phase 2 befor 1 ERROR");
            alert.setHeaderText("There are error, read dwon!!!");
            alert.setContentText("Error: Cannot calculate percent improvement before starting Phase 1");
            alert.showAndWait();
        
        }
            
        return percentImprovement;
    }

    public void calculateTotalTimeForAllPhases(){
        if (FirstPage.isPhase1Selected) {

                    totalTimeP1 = MainProgram.driver.calculateTotalTime(); // Calculate total time separately
                   
        } 
        else if (FirstPage.isPhase2Selected) {
                    // Similarly, calculate total time separately for phase 2
                    totalTimeP2 = MainProgram.driver.calculateTotalTime(); // Calculate total time separately
                   
        } 
    }

    public void startSimulation() {
        // Cancel the existing timer if it's not null
        if (timer != null) {
            timer.cancel();
        }

        // Reset the delivery status of packages
        resetPackageDeliveryStatus();

        // Create a new timer
        timer = new Timer();

        TimerTask simulationTask = new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) {
                    secondsPassed += 10;
                    Platform.runLater(() -> {
                        CounterTimeLabel.setText(formatTime(secondsPassed));
                    });
                    if (allDelivered(MainProgram.driver)) {
                        Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FINISH");
                            alert.setHeaderText("THE SIMULATION IS DONE");
                            alert.setContentText("Have a nice day!");
                            alert.showAndWait();
                            isPhase1comblete =true;
                            MainProgram.driver.isTransitionPaused = false;

                            calculateTotalTimeForAllPhases();
                            isStartClicked = false;
                            CounterNo_SimulationLabel.setText(formatCounterNo_Simulation(++numOfSumuolation));
                            percentLabelP2.setText(formatPercent(calculatePercentImprovement()));
                            updatePhase1Metrics();  
                        });

                        timer.cancel();
                    }
                }
            }
        };

        timer.schedule(simulationTask, 0, 103);
    }
    
    private static void resetPackageDeliveryStatus() {
                List<Package> Packages = MainProgram.packages;

        for (Package aPackage : Packages) {
            aPackage.isDelivered = false;
        }
    }
    
    private void stopCurrentSimulation() {
        if (MainProgram.driver.pathTransition != null) {
            MainProgram.driver.pathTransition.stop() ; // Stop the PathTransition animation
        }
    }
    public static void pauseSimulation() {
        isPaused = !isPaused; // Toggle pause state

        if (MainProgram.driver.pathTransition != null) {
            PathTransition path = MainProgram.driver.pathTransition;
            if (isPaused && path.getStatus() == Animation.Status.RUNNING) {
                path.pause();
            }
        }
    }

    public static void resumeSimulation() {
        isPaused = false; // Resume the simulation
            PathTransition path = MainProgram.driver.pathTransition;

        if (path != null) {

            if (path.getStatus() == Animation.Status.PAUSED) {
                path.play();
            }
        }
    }

    public static boolean allDelivered(DeliveryDriver driver) {
        List<Package> Packages = MainProgram.packages;
        
        for (Package aPackage : Packages) {
            if (aPackage != null) {
                if (!aPackage.isDelivered) {
                    return false;
                }
            }
        }
        
        return true;
    }
    

    public static String formatTime(int seconds) {
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
    
    public static String formatDistance(double distance) {
        return String.format("%.2f %s", distance,"Km");
    }
    
    
    public static String formatCounterNo_Simulation(int num) {
        return String.format("%d",  num ); // Replace "Currency" with your desired currency symbol or abbreviation
    } 
    
    public static String formatGasolineCost(double cost) {
        return String.format("%s%.2f", " SAR " , cost ); // Replace "Currency" with your desired currency symbol or abbreviation
    }
    public static String formatPercent(double percent) {
        return String.format("%.2f%%", percent); // Formats the double as a percentage with two decimal places
    }
    
    private void openFirstPage() {
        FirstPage firstPage = new FirstPage(); 
        Stage stage = new Stage(); 
        firstPage.start(stage); 
    }
    
    public void endSimulation() {
        if (!isStartClicked) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("End simulation");
            alert.setHeaderText("Cannot end simulation before starting.");
            alert.setContentText("--------------");

            alert.showAndWait();

            return;
        }
    
        if (timer != null) {
            timer.cancel();
        }
    
        if (MainProgram.driver.pathTransition != null) {
            Platform.runLater(() -> {
                MainProgram.driver.pathTransition.stop();
                MainProgram.driver.pathTransition.setPath(null);
                MainProgram.driver.pathTransition.setCycleCount(1);
                List<List<Intersection>> calculateShortestPaths = MainProgram.driver.calculateShortestPathsBetweenDestinations(MainProgram.choosenBulding) ; 
                 double totalDistance = MainProgram.driver.calculateTotalDistance(calculateShortestPaths);
                 CounterDistanceLabel.setText(formatDistance(totalDistance));
    
                 double totalGasolineCost = MainProgram.driver.calculateTotalGasolineCost(calculateShortestPaths);
                 CounterCostLabel.setText(formatGasolineCost(totalGasolineCost));
                 MainProgram.driver.moveCarTo(MainProgram.choosenBulding);
                 int totalTime = MainProgram.driver.calculateTotalTime();
                 CounterTimeLabel.setText(formatTime(totalTime));
                 updatePhase1Metrics();                 
                 calculateTotalTimeForAllPhases(); 
                 percentLabelP2.setText(formatPercent(calculatePercentImprovement()));
                 highlightBuildingsWithPackages();
                 addToolTipsToAllBuildings();
                 TooltipOfBuildings();

                CounterNo_SimulationLabel.setText(formatCounterNo_Simulation(++numOfSumuolation));
                isPhase1comblete =true;
                isStartClicked = false;
                MainProgram.driver.isTransitionPaused = false; 
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("FINISH");
                    alert.setHeaderText("THE SIMULATION IS DONE");
                    alert.setContentText("Have a nice day!");
                    alert.showAndWait();

                });
                
                
                
            });
        
        }
    }
    
    public  void restSumaltion(){
        if (timer != null) {
        timer.cancel();
        }
        PathTransition path = MainProgram.driver.pathTransition;
        if (MainProgram.driver.pathTransition != null) {
            Platform.runLater(() -> {
                path.stop();
                path.setPath(null);
                path.setCycleCount(1);
                CounterDistanceLabel.setText("00.00 Km");
                CounterCostLabel.setText("SAR 00,00");
                MainProgram.driver.moveCarTo(MainProgram.choosenBulding);
            

                });
    
        }

    } 

    public static void openPhase2() {
        Stage newStage = new Stage();
        MainGUISimulation phase2 = new MainGUISimulation();
        phase2.start(newStage);

        
    }

    public void TooltipOfBuildings() {
        List<Package> packages = MainProgram.packages;
        for (Package aPackage : packages) {
            Customer customer = aPackage.getCustomer();
            Building destinationBuilding = customer.getBuilding();
            String buildingName = destinationBuilding.getLocation().getName();
            int buildingIndex = Integer.parseInt(buildingName);

            // Ensure that the GUI element is not null before proceeding
            if (destinationBuilding != null && buildings.get(buildingIndex - 1) != null) {
                // Create the tooltip
                Tooltip tooltipBuilding = new Tooltip(aPackage.getPackageInformation());

                // Install the tooltip on the building element
                Tooltip.install(buildings.get(buildingIndex - 1), tooltipBuilding);

                // Set up mouse entered event handler
                buildings.get(buildingIndex - 1).setOnMouseEntered(event -> {
                    
                    if (buildings.get(buildingIndex - 1).contains(event.getX(), event.getY())) {
                        // Show the tooltip only if the mouse is within the building bounds
                        tooltipBuilding.show(buildings.get(buildingIndex - 1), event.getScreenX(), event.getScreenY() + 20);
                    }
                });

                // Set up mouse exited event handler
                buildings.get(buildingIndex - 1).setOnMouseExited(event -> {
                    tooltipBuilding.hide();
                });
            }
        }
    }
    public void addToolTipsToAllBuildings() {

        for (int i = 0; i < buildings.size(); i++) {
            Rectangle building = buildings.get(i);
            int buildingNumber = i + 1;
    
            // Create the tooltip with the building number
            Tooltip tooltip = new Tooltip("Building Number: " + buildingNumber);
    
            // Install the tooltip on the building
            Tooltip.install(building, tooltip);
    
            // Set up mouse entered event handler
            building.setOnMouseEntered(event -> {
                // Check if the mouse is within the building bounds
                if (building.contains(event.getX(), event.getY())) {
                    // Show the tooltip
                    tooltip.show(building, event.getScreenX(), event.getScreenY() + 20);
                }
            });
    
            // Set up mouse exited event handler
            building.setOnMouseExited(event -> {
                // Hide the tooltip
                tooltip.hide();
            });
        }
    }
    
    public void highlightBuildingsWithPackages()  {
        List<Package> packages = MainProgram.packages;
        packages.get(1);
        for (Package aPackage : packages) {
            Customer customer = aPackage.getCustomer();
            Building destinationBuilding = customer.getBuilding();
            String buildingName = destinationBuilding.getLocation().getName();

            int buildingIndex = Integer.parseInt(buildingName);
            buildings.get(buildingIndex - 1).setFill(Color.GREEN);
            
        }
    }

    public static void resetBuildingColors() {
        for (int i = 0; i < buildings.size(); i++) {
            Rectangle building = buildings.get(i);
            Color color;

            if (i >= 0 && i < 52) {
                // Set GREY color for index 0 to 51
                color = Color.GREY;
            } else if (i >= 52 && i < 91) {
                // Set BLUE color for index 52 to 90
                color = Color.BLUE;
            } else if (i >= 91 && i < 129) {
                // Set "#C0392B" color for index 91 to 127
                color = Color.web("#C0392B");
            }else {
                // Handle additional ranges or default color if needed
                color = Color.LIGHTGRAY;
            }

            building.setFill(color);
        }

    }
    public void updatePhase1Metrics() {
        if (FirstPage.isPhase1Selected) {
            List<List<Intersection>> calculateShortestPaths = MainProgram.driver.calculateShortestPathsBetweenDestinations(MainProgram.choosenBulding) ; 
            total_Distance = MainProgram.driver.calculateTotalDistance(calculateShortestPaths);
            total_GasolineCost = MainProgram.driver.calculateTotalGasolineCost(calculateShortestPaths);
            total_Time = MainProgram.driver.calculateTotalTime();
        }

    }
}

    
    



