public class User {
    private String username;
    private String password;
    private String licenseNumber;
    private boolean isRentalAgent;

    public User(String username, String password, String licenseNumber, boolean isRentalAgent) {
        this.username = username;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.isRentalAgent = isRentalAgent;
    }

    public String getUsername() {
        return username;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public boolean isRentalAgent() {
        return isRentalAgent;
    }

    // בדיקת סיסמה ללא חשיפתה
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    @Override
    public String toString() {
        String role = isRentalAgent ? "Rental Agent" : "Customer";
        return "Username: " + username + " | License: " + licenseNumber + " | Role: " + role;
    }
}