

public class Normal extends Package  {

    public Normal(Customer customer, int packageId,int delay) {
        super(customer,  packageId,delay);

    }
    public Normal(Normal original) {
        super(original);
    }
   
    public String getPackageInformation() {
        return "Package Information:\n" +
                "Customer ID: " + getCustomer().getID() + "\n" +
                "Type of Package: " + getTypeOfPackage() + "\n" +
                "Building Number: " + getCustomer().getBuilding().getBuildingNumber() ; 
              }
    
    private String getTypeOfPackage() {
        return "Normal";
    }
}
