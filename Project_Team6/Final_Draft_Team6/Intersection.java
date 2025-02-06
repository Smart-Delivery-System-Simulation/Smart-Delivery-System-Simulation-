



public class Intersection  {
    private String name;
    private int x;
    private int y;
    
    public Intersection (int x, int y,String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        
      
    }

    

    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }
    
    public String getName() {
        return this.name;
    }
    public double getDistanceTo(Intersection nextIntersection) {
        if (this.getX() == -1 || this.getY() == -1 || nextIntersection.getX() == -1 || nextIntersection.getY() == -1) {
            return Double.MAX_VALUE; // or handle the uninitialized case according to your logic
        }
    
        double deltaX = Math.abs(this.getX() - nextIntersection.getX());
        double deltaY = Math.abs(this.getY() - nextIntersection.getY());
    
        double pixelToKmConversionFactor = 0.01;
        double distanceInKm = (deltaX + deltaY) * pixelToKmConversionFactor;
    
        return distanceInKm;
    }
    
    
    public double calculateGasolineCost(Intersection nextIntersection) {
        double costPerKilometer = 2.5; 
        return  getDistanceTo(nextIntersection) * costPerKilometer;
    }


    
}

