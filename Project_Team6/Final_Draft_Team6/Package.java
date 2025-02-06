import java.util.List;

public abstract class Package  {
    private Customer customer1;
    public boolean isDelivered;
    private int packageId;
    private List<Intersection > path;
    public int delay;

    public Package (Customer customer1,  int packageId,int delay) {
        this.customer1 = customer1;
        this.isDelivered = false;
        this.packageId = packageId;
        this.delay=delay;
        
    }
    // Shallow Copy
    public Package(Package original) {
        this.customer1 = original.customer1;
        this.packageId = original.packageId;
        this.delay = original.delay;
    }
   
    public abstract String getPackageInformation();

    public int getPackageId() {
        return packageId;
    }
    public void setCustomer(Customer customer) {
        this.customer1 = customer;
    }
    public Customer getCustomer() {
        return customer1;
    }

    public List<Intersection > getPath() {
        return path;
    }
   public void setPath(List<Intersection> path){
    this.path = path;
   }

    }


    
   

   
    

