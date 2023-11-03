public class User {
    private String username;
    private String password;
    private boolean isAdmin;


    // New constructor for creating a user with the given username and password (not admin by default).
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;
    }

    // Same but with the admin status
    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    // Getter method to retrieve the username of the user
    public String getUsername() {
        return username;
    }

    // Setter method to update the username of the user
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method to retrieve the password of the user
    public String getPassword() {
        return password;
    }

    // Setter method to update the password of the user
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter method to check if the user is an admin
    public boolean isAdmin() {
        return isAdmin;
    }

    // Setter method to update the admin status of the user
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
