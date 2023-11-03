import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authentication {
    private static Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>(); // A list to store the user information

    // Creating a new user with provided username, password, and boolean admin
    public void createUser(String username, String password, boolean isAdmin) {
        User user = new User(username, password, isAdmin);// Creating a new User OBJECT
        this.users.add(user); // Adding the user to the list of users
    }


    //Having the user input a new user.
    public void createUser() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        this.createUser(username, password, false); // Calling the previous createUser method with this new information
    }

    // New method to find a user by their username.
    public User getUserByUserName(String userName) {
        for (User user : this.users) {
            if (user.getUsername().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    // New method to authenticate a user by verifying their username and password
    public User authenticate() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Returns the user if the authentication works
            }
        }
        return null;
    }

    public void loggedInUser(BookStock bookStock, User loggedUser) {
        Scanner userOptionScanner = new Scanner(System.in);
        int userOptionChoice = 10;

        while (userOptionChoice != 0) {
            System.out.println("\n◉ User Menu:");
            System.out.println("1・ List all books");
            System.out.println("2・ Search for a book");
            System.out.println("3・ List your borrowed books");
            System.out.println("0・ Log out");

            System.out.print("Choose an option: ");
            userOptionChoice = userOptionScanner.nextInt();

            switch (userOptionChoice) {
                case 1:
                    bookStock.booksStock(loggedUser);
                    break;
                case 2:
                    BookStock.findBook();
                    break;
                case 3:
                    //   listBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Logging out... Hope to see you soon!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("✖︎ Invalid choice ✖︎ Please try again.");
            }
        }
    }

    public void loggedInAdmin(BookStock bookStock, User loggedUser) {
        Scanner userOptionScanner = new Scanner(System.in);
        int userOptionChoice = 10;

        while (userOptionChoice != 0) {
            System.out.println("\n⦿ Admin Menu:");
            System.out.println("1・ Add a new book to stock");
            System.out.println("2・ Search for a book");
            System.out.println("3・ List all books");
            System.out.println("0・ Log out");

            System.out.print("Choose an option: ");
            userOptionChoice = userOptionScanner.nextInt();

            switch (userOptionChoice) {
                case 1:
                    bookStock.addBook();
                    break;
                case 2:
                    bookStock.findBook();
                    break;
                case 3:
                    bookStock.booksStock(loggedUser);
                    break;
                case 0:
                    System.out.println("Logging out... Hope to see you soon!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("✖︎ Invalid choice ✖︎ Please try again.");
            }
        }
    }
}
