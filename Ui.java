import java.util.Scanner;

public class Ui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // יצירת מופע של מחלקת הניהול עם גודל קבוע מראש (למשל: עד 10 רכבים ו-10 לקוחות)
        RentalSystem rentalSystem = new RentalSystem(10, 10);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== מערכת השכרת רכבים ===");
            System.out.println("1. הוספת רכב חדש למערכת");
            System.out.println("2. הוספת לקוח חדש למערכת");
            System.out.println("3. הצגת רשימת הרכבים וסטטוס זמינות");
            System.out.println("4. הצגת רשימת הלקוחות הרשומים");
            System.out.println("5. ביצוע השכרת רכב (שיוך לקוח לרכב)");
            System.out.println("6. ביצוע החזרת רכב (שחרור רכב)");
            System.out.println("7. יציאה מהמערכת");
            System.out.print("בחר אפשרות (1-7): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // KAN-84: חיבור פעולת הוספת רכב
                    System.out.print("הכנס מספר רישוי: ");
                    String licensePlate = scanner.nextLine();
                    System.out.print("הכנס יצרן: ");
                    String make = scanner.nextLine();
                    System.out.print("הכנס דגם: ");
                    String model = scanner.nextLine();
                    System.out.print("הכנס שנת ייצור: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    Car newCar = new Car(licensePlate, make, model, year);
                    boolean carAdded = rentalSystem.addCar(newCar);

                    if (carAdded) {
                        System.out.println("--> הרכב נוסף בהצלחה למערכת!");
                    } else {
                        System.out.println("--> שגיאה: מערך הרכבים מלא, לא ניתן להוסיף רכב נוסף.");
                    }
                    break;

                case "2":
                    // KAN-84: חיבור פעולת הוספת לקוח
                    System.out.print("הכנס תעודת זהות: ");
                    String id = scanner.nextLine();
                    System.out.print("הכנס שם מלא: ");
                    String fullName = scanner.nextLine();
                    System.out.print("הכנס מספר טלפון: ");
                    String phoneNumber = scanner.nextLine();

                    Customer newCustomer = new Customer(id, fullName, phoneNumber);
                    boolean customerAdded = rentalSystem.addCustomer(newCustomer);

                    if (customerAdded) {
                        System.out.println("--> הלקוח נוסף בהצלחה למערכת!");
                    } else {
                        System.out.println("--> שגיאה: מערך הלקוחות מלא, לא ניתן להוסיף לקוח נוסף.");
                    }
                    break;

                case "3":
                    // KAN-84: הצגת רכבים
                    System.out.println("--> הצגת רשימת הרכבים (יושלם עם פונקציית ההצגה של הצוות)");
                    break;

                case "4":
                    // KAN-84: הצגת לקוחות
                    System.out.println("--> הצגת רשימת הלקוחות (יושלם עם פונקציית ההצגה של הצוות)");
                    break;

                case "5":
                    // KAN-81: ביצוע השכרת רכב
                    System.out.println("--> ביצוע השכרת רכב (יושלם במסגרת משימות ההשכרה)");
                    break;

                case "6":
                    // KAN-81: ביצוע החזרת רכב
                    System.out.println("--> ביצוע החזרת רכב (יושלם במסגרת משימות ההחזרה)");
                    break;

                case "7":
                    System.out.println("יוצא מהמערכת. להתראות!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("בחירה לא חוקית, אנא נסה שוב.");
                    break;
            }
        }

        scanner.close();
    }
}