import java.util.Random;

public class CustomerWithContact extends Customer implements Reachable {
    private String customerNumber;

    public CustomerWithContact(Customer original) {
        super(original);
        this.customerNumber = "05" + (10000000 + new Random().nextInt(90000000));
    }

    // shallow copy
    public CustomerWithContact(CustomerWithContact original) {
        super(original.getID(), original.getBuilding());
    }

    @Override
    public String getPhoneNumber() {
        return customerNumber;
    }
}