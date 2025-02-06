import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int ID;
    private Building building;
    private List<Package> assignedPackages;

    public Customer(int ID, Building building) {
        this.ID = ID;
        this.building = building;
        this.assignedPackages = new ArrayList<>();
    }
    public Customer(Customer original) {
        this(original.getID(), original.getBuilding());
    }

    public Building getBuilding() {
        return building;
    }

    public int getID() {
        return ID;
    }

    public List<Package> getAssignedPackages() {
        return assignedPackages;
    }

    public void addAssignedPackage(Package newPackage) {
        assignedPackages.add(newPackage);
    }
}