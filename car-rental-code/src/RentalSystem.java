public class RentalSystem {
    private Car[] cars;
    private Customer[] customers;
    private User[] users; // הוגדר בסקופ המקורי

    private int carCount;
    private int customerCount;
    private int userCount;

    private User currentUser;

    public RentalSystem(int maxCars, int maxCustomers, int maxUsers) {
        cars = new Car[maxCars];
        customers = new Customer[maxCustomers];
        users = new User[maxUsers];

        carCount = 0;
        customerCount = 0;
        userCount = 0;
        currentUser = null;
    }

    // משימה 5: הוספת לקוח
    public void addCustomer(Customer customer) {
        if (customerCount < customers.length) {
            customers[customerCount] = customer;
            customerCount++;
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Warning: Customers array is full. Cannot add new customer.");
        }
    }

    // משימה 6: הוספת רכב
    public void addCar(Car car) {
        if (carCount < cars.length) {
            cars[carCount] = car;
            carCount++;
            System.out.println("Car added successfully.");
        } else {
            System.out.println("Warning: Cars array is full. Cannot add new car.");
        }
    }
}