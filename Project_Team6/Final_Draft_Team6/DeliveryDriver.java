import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class DeliveryDriver {

    private List<Package> packages;
    private int currentX;
    private int currentY;
    public  PathTransition pathTransition;
    private  double gasolineCost;
    private double incrementGasoline;
    private double incrementDistance;
    private  double distance;
    public  boolean isTransitionPaused = false;

    public void setGasolineCost(double gasolineCost){

        this.gasolineCost=gasolineCost;
    }
   
    

    public void setDistance(double distance){
        this.distance=distance;
    }
   
   
    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
   
    
      public List<Package> getPackages() {
        return packages;
    }

public double calculateTotalDistance(List<List<Intersection>> packages) {

    double totalDistance = 0.0;

    for (List<Intersection> paths : packages) {

        if (!paths.isEmpty()) {

            Intersection currentPath = paths.get(0);

            for (int i = 1; i < paths.size(); i++) {

                Intersection nextPath = paths.get(i);
                totalDistance += currentPath.getDistanceTo(nextPath);
                currentPath = nextPath;
            }
        }
    }

    return totalDistance;
}

private int delayByIndex(int index) {

    List<Package> Packages = MainProgram.packages;

    if (index >= 0 && index < Packages.size()) {
        return Packages.get(index).delay;
    } else {
      
        return 0; 
    }
}


public double calculateTotalGasolineCost(List<List<Intersection>> packages) {
    double totalGasolineCost = 0.0;

    for (List<Intersection> paths : packages) {
        if (!paths.isEmpty()) {
            Intersection currentPath = paths.get(0);

            for (int i = 1; i < paths.size(); i++) {
                Intersection nextPath = paths.get(i);
                totalGasolineCost += currentPath.calculateGasolineCost(nextPath);
                currentPath = nextPath;
            }
        }
    }

    return totalGasolineCost;
}


public void moveCarTo(List<Intersection> packages) {
    double firstX=0;
    double firstY=0;
    double lastX=0;
    double lastY=0;
    if (!packages.isEmpty()) {
        Intersection firstPackage = packages.get(0);
             firstX = firstPackage.getX();
             firstY = firstPackage.getY();
        Intersection lastPackage = packages.get(packages.size() - 1);
             lastX = lastPackage.getX();
             lastY = lastPackage.getY();

            double finalPointX  = lastX-  firstX;
            double finalPointY  = lastY-  firstY;


            MainGUISimulation.car.setTranslateX(finalPointX);
            MainGUISimulation.car.setTranslateY(finalPointY);
        }
    }


public List<List<Intersection>> calculateShortestPathsBetweenDestinations(List<Intersection> destinations) {

    List<List<Intersection>> paths = new ArrayList<>();
    
        for (int i = 0; i < destinations.size() - 1; i++) {
            Intersection start = destinations.get(i);
            Intersection destination = destinations.get(i + 1);
            
            List<Intersection> nearestIntersections = findShortestPath(MainProgram.graph, start, destination); 
           
            paths.add(nearestIntersections);
        }

        return paths;
    }

public static List<Intersection> findShortestPath(Map<Intersection, List<Intersection>> graph, Intersection start, Intersection destination) {

        Map<Intersection, Double> distance = new HashMap<>();
        Map<Intersection, Intersection> previous = new HashMap<>();
        PriorityQueue<Intersection> pq = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
    
        // Initialize distances
        for (Intersection intersection : graph.keySet()) {

            distance.put(intersection, Double.MAX_VALUE);
        }

        distance.put(start, 0.0);
        pq.offer(start);
    
        while (!pq.isEmpty()) {

            Intersection current = pq.poll();
            if (current.equals(destination)) {
                break;
            }
    
            double currentDistance = distance.get(current);
    
            
            List<Intersection> neighbors = graph.getOrDefault(current, new ArrayList<>());


            for (int i = 0; i < neighbors.size(); i++) {

                Intersection neighbor = neighbors.get(i);
                double newDistance = currentDistance + current.getDistanceTo(neighbor);
            
                
            
                if (newDistance < distance.getOrDefault(neighbor, Double.MAX_VALUE)) {

                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    pq.offer(neighbor);

                }
            }
        }
    
        // Reconstruct the shortest path
        List<Intersection> shortestPath = new ArrayList<>();
        Intersection current = destination;

        while (previous.containsKey(current)) {

            shortestPath.add(current);
            current = previous.get(current);
        }

        shortestPath.add(start);
        Collections.reverse(shortestPath);
    
        return shortestPath;
    }
    
    
public void createPathForPackages(List<List<Intersection>> packages) {

    if (packages == null || packages.isEmpty()) {
        return;
    }

    playPathTransitions(packages, 0);
}

private void playPathTransitions(List<List<Intersection>> packages, int index) {

    if (index >= packages.size()) {
        return;
    }

    int delay = delayByIndex(index);
    Path path = generatePath(packages.get(index));
    
    moveDriver(path, () -> playPathTransitions(packages, index + 1),delay);

}

private Path generatePath(List<Intersection> intersections) {

    Path path = new Path();
    if (intersections.isEmpty()) {
        return path;

    }

    Intersection currentintersection = intersections.get(0);
    path.getElements().add(new MoveTo(currentintersection.getX(), currentintersection.getY()));
    
    for (int i = 1; i < intersections.size(); i++) {

        Intersection nextintersection = intersections.get(i);
        path.getElements().add(new LineTo(nextintersection.getX(), nextintersection.getY()));

        incrementDistance = currentintersection.getDistanceTo(nextintersection);
        incrementGasoline = currentintersection.calculateGasolineCost(nextintersection);
        gasolineCost += incrementGasoline ;
        distance+=incrementDistance;
        currentintersection = nextintersection;
        currentX = currentintersection.getX();
        currentY = currentintersection.getY();
       
        

    }
   

    return path;
}

public int calculateTotalTime(){

    int totalDelay=0;
    
    List<Package> packages = MainProgram.packages;

    for (Package singlePackage : packages) {

        totalDelay+=singlePackage.delay*60;
    }
    
    double totalDistance = calculateTotalDistance(MainProgram.driver.calculateShortestPathsBetweenDestinations(MainProgram.choosenBulding));
    double totalDourtion=40; // Scale factor used to predict the total time 
    double totalTime = totalDelay + totalDistance*1000/totalDourtion; // Multiplying by 1000 to convert totalDistance from kilometers to meters
    int totalTimrCast = (int) totalTime;

    return totalTimrCast;
}

public void moveDriver(Path path, Runnable onFinish,int delay) {

    if (!path.getElements().isEmpty() && MainGUISimulation.isStartClicked) {

        double totalDistance = calculateTotalDistance(path.getElements());
        double duration = totalDistance / 250;
        pathTransition = new PathTransition();
        pathTransition.setNode(MainGUISimulation.car);
        pathTransition.setCycleCount(1);
        pathTransition.setDuration(Duration.seconds(duration)); 
        pathTransition.setPath(path);
        pathTransition.setOnFinished(e -> {
        MainGUISimulation.CounterDistanceLabel.setText(MainGUISimulation.formatDistance(distance));
        MainGUISimulation.CounterCostLabel.setText(MainGUISimulation.formatGasolineCost(gasolineCost));
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(delay/2));

        pauseTransition.setOnFinished(event -> {

                deliverPackage(currentX, currentY);
                onFinish.run();
                isTransitionPaused=false;

            });

            pauseTransition.play();
            isTransitionPaused=true;

        });

        pathTransition.play();
    }
}





private double calculateTotalDistance(ObservableList<PathElement> elements) {

    double totalDistance = 0.0;

    if (elements.size() >= 2) {

        MoveTo moveTo = (MoveTo) elements.get(0);
        double startX = moveTo.getX();
        double startY = moveTo.getY();

        for (int i = 1; i < elements.size(); i++) {

            if (elements.get(i) instanceof LineTo) {
                LineTo lineTo = (LineTo) elements.get(i);
                double endX = lineTo.getX();
                double endY = lineTo.getY();

                double distance = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                totalDistance += distance;

                startX = endX;
                startY = endY;
            }
        }
    }

    return totalDistance;
    
}



private void deliverPackage(int currentX, int currentY) {

    boolean deliveredPackageFound = false;
    List<Package> Packages = MainProgram.packages;
  

    for (Package aPackage : Packages) {

        if (!aPackage.isDelivered) {

            Customer customer = aPackage.getCustomer();
            Building destinationBuilding= customer.getBuilding();

            if (currentX == destinationBuilding.getLocation().getX() && currentY == destinationBuilding.getLocation().getY()) {

                aPackage.isDelivered = true;
                deliveredPackageFound = true;
                String buildingName = destinationBuilding.getLocation().getName();
                int buildingIndex = Integer.parseInt(buildingName);
                List<Rectangle> building = MainGUISimulation.buildings;
                building.get(buildingIndex - 1 ).setFill(Color.GREEN);
              
                }
                }

                if (hasNextPackage(aPackage) && aPackage.isDelivered) {
                    moveToNextPackage();
                }
            }
        
    

    if (!deliveredPackageFound) {
      
    }

}

private void moveToNextPackage() {

    boolean nextPackageFound = false;

    for (int i = 0; i < MainProgram.packages.size(); i++) {

        Package currentPackage = MainProgram.packages.get(i);

        if (currentPackage.isDelivered) {

            for (int j = i + 1; j < MainProgram.packages.size(); j++) {

                Package nextPackage = MainProgram.packages.get(j);
                if (!nextPackage.isDelivered) {

                    nextPackageFound = true;
                    break;
                }
            }

            if (nextPackageFound) {
                break;
            }
        }
    }

    if (!nextPackageFound) {
       
    }
}

private boolean hasNextPackage(Package currentPackage) {

    List<Package> Packages = MainProgram.packages;

    int currentIndex = Packages.indexOf(currentPackage);

    return currentIndex < Packages.size() - 1;
    
    }
}
