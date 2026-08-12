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

    // שדרוג משימה 5: הוספת לקוח (עם מניעת כפילויות)
    public void addCustomer(Customer customer) {
        if (isCustomerExists(customer.getId())) {
            System.out.println("Error: Customer with ID " + customer.getId() + " already exists in the system.");
            return; // עצירת הפונקציה
        }

        if (customerCount < customers.length) {
            customers[customerCount] = customer;
            customerCount++;
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Warning: Customers array is full. Cannot add new customer.");
        }
    }

    // שדרוג משימה 6: הוספת רכב (עם מניעת כפילויות)
    public void addCar(Car car) {
        if (isCarExists(car.getLicensePlate())) {
            System.out.println("Error: Car with license plate " + car.getLicensePlate() + " already exists in the system.");
            return; // עצירת הפונקציה
        }

        if (carCount < cars.length) {
            cars[carCount] = car;
            carCount++;
            System.out.println("Car added successfully.");
        } else {
            System.out.println("Warning: Cars array is full. Cannot add new car.");
        }
    }

    // פונקציית עזר: בודקת אם לקוח עם תעודת זהות כזו כבר קיים
    private boolean isCustomerExists(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getId().equals(id)) {
                return true; // נמצאה כפילות
            }
        }
        return false; // הלקוח לא קיים במערכת
    }

    // פונקציית עזר: בודקת אם רכב עם מספר רישוי כזה כבר קיים
    private boolean isCarExists(String licensePlate) {
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getLicensePlate().equals(licensePlate)) {
                return true; // נמצאה כפילות
            }
        }
        return false; // הרכב לא קיים במערכת
    }


    // משימה חדשה: מחיקת רכב מהמערכת ללא השארת חורים במערך
    public boolean removeCar(String licensePlate) {
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getLicensePlate().equals(licensePlate)) {

                // מניעת מחיקה של רכב שמושכר כרגע
                if (cars[i].isRented()) {
                    System.out.println("Error: Cannot remove a rented car. It must be returned first.");
                    return false;
                }

                // העתקת הרכב האחרון במערך אל המיקום של הרכב שאנחנו מוחקים
                cars[i] = cars[carCount - 1];

                // ניקוי התא האחרון ועדכון המונה
                cars[carCount - 1] = null;
                carCount--;

                System.out.println("Car removed successfully.");
                return true;
            }
        }

        // אם סיימנו את הלולאה ולא מצאנו את הרכב
        System.out.println("Error: Car with license plate " + licensePlate + " not found.");
        return false;
    }
}