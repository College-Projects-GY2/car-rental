import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalSystem system = new RentalSystem(100, 100, 10); // גדלים קבועים מראש

        // הוספת נתוני דמו לבדיקה
        system.addCar(new Car("123-45-678", "Toyota", "Corolla", 2022));
        system.addCustomer(new Customer("312345678", "Israel Israeli", "050-1234567"));

        boolean isRunning = true;

        System.out.println("--- Welcome to the Console Car Rental System ---");

        while (isRunning) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("> ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter Car License Plate: ");
                    String rentPlate = scanner.nextLine();

                    if (system.rentCar(customerId, rentPlate)) {
                        System.out.println("Operation Successful: Car rented.");
                    } else {
                        System.out.println("Operation Failed: Could not rent the car.");
                    }
                    break;

                case "2":
                    System.out.print("Enter Car License Plate to return: ");
                    String returnPlate = scanner.nextLine();

                    if (system.returnCar(returnPlate)) {
                        System.out.println("Operation Successful: Car returned.");
                    } else {
                        System.out.println("Operation Failed: Could not return the car.");
                    }
                    break;

                case "3":
                    System.out.println("Exiting system. Goodbye!");
                    isRunning = false; // שבירת לולאה
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}