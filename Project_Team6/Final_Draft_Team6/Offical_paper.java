public class Offical_paper extends Package {

    public Offical_paper(Customer customer, int packageId, int delay) {
        super(customer, packageId, delay);
    }

    public Offical_paper(Offical_paper original) {
        super(original);
        // Change the customer to CustomerWithContact if it's not already
        if (!(getCustomer() instanceof CustomerWithContact)) {
            setCustomer(new CustomerWithContact(getCustomer()));
        }
        contactCustomer();
    }

    @Override
    public String getPackageInformation() {
        Customer customer = getCustomer();
        String phoneNumber = (customer instanceof CustomerWithContact) ?
                ((CustomerWithContact) customer).getPhoneNumber() : "N/A";

        return "Package Information:\n" +
                "Package ID: " + getPackageId() + "\n" +
                "Customer ID: " + customer.getID() + "\n" +
                "Type of Package: " + getTypeOfPackage() + "\n" +
                "Building Number: " + customer.getBuilding().getBuildingNumber() + "\n" +
                "Customer Phone Number: " + phoneNumber;
    }

    public void contactCustomer() {
        this.delay = 3;
    }

    private String getTypeOfPackage() {
        return "OfficalPaper";
    }

    
}
