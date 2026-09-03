public class User {
    private String username;
    private String password;

    // בנאי המאתחל את שם המשתמש והסיסמה
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // מתודת בדיקת סיסמה (PasswordCheck) המבוקשת במשימה KAN-66
    public boolean passwordCheck(String inputPassword) {
        // מחזיר true אם הסיסמה שהוזנה תואמת לסיסמה השמורה
        return this.password != null && this.password.equals(inputPassword);
    }

    // Getters
    public String getUsername() {
        return username;
    }
}