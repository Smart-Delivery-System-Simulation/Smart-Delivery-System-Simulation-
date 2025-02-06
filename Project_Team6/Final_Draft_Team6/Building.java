import javafx.scene.shape.Rectangle;

public class Building {
    private int buildingNumber;
    private Intersection  location; 
    private Rectangle guiElement;
    private Package assignedPackage;

    public Building(int buildingNumber, Intersection  location,Rectangle guiElement) {
        this.buildingNumber = buildingNumber;
        this.location = location;
        this.guiElement=guiElement;
        this.assignedPackage = null;
    }

    public int getBuildingNumber() {
        return this.buildingNumber;
    }

    public void assignPackage(Package pkg) {
        this.assignedPackage = pkg;
    }

    public Package getAssignedPackage() {
        return assignedPackage;
    }

    public Intersection  getLocation() {
        return location;
    }
    public Rectangle getGuiElement(){
        return this.guiElement;
    }
    

    
}


