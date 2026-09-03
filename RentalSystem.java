public class RentalSystem {

    private Car[] cars;
    private int carCount;

    private Customer[] customers;
    private int customerCount;


    public RentalSystem(int maxCars, int maxCustomers) {
        this.cars = new Car[maxCars];
        this.carCount = 0;

        this.customers = new Customer[maxCustomers];
        this.customerCount = 0;
    }

    // מתודות בסיסיות למעקב אחר המונים
    public int getCarCount() {
        return carCount;
    }

    public int getCustomerCount() {
        return customerCount;
    }
}