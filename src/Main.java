import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner userOptionScanner = new Scanner(System.in);
    static BookStock stock = new BookStock(); // An instance of BookStock to manage the library's books
    static String[] userOptions = new String[]{"1・ Log in", "2・ Create a new account", "0・ Exit"};


    public static void main(String[] args) {
        int userOptionChoice = 10;

        Authentication auth = new Authentication(); //An instance of the Authentication class to manage users

        // Default users
        auth.createUser("admin", "admin123", true);
        auth.createUser("user1", "user123", false);

        // Default Book objects
        Book book = new Book("Children of Blood and Bone", "Tomi Adeyemi", 2018);
        Book book1 = new Book("The Night Circus ", "Erin Morgenstern",  2011);
        Book book2 = new Book("Fairy Tale", "Stephen king", 2022);
        Book book3 = new Book("The Name of the Wind", "Patrick Rothfuss", 2007);



        User otherUser = auth.getUserByUserName("user1"); // Getting the chosen user
        book.setBorrowed(otherUser); // Setting the user as the borrower of a book

        User loggedUser = null; // Initializing a variable to store the logged-in user

        System.out.println("\n◆ Welcome to the website of your favorite library! Please login or be welcomed to create a new account ◆");
        while (userOptionChoice != 0) {
            for (int i = 0; i < userOptions.length; i++) {
                System.out.println(userOptions[i]);
            }
            System.out.println("\nWhat do you want to do: ");
            userOptionChoice = userOptionScanner.nextInt();

            switch (userOptionChoice) {
                case 1:
                    loggedUser = auth.authenticate(); // Authenticating the user
                    if (Objects.isNull(loggedUser)) {
                        System.out.println("✖︎ User not found ✖︎ Please try again or create a new account ");
                        break;
                    }

                    if (loggedUser.isAdmin()) {
                        auth.loggedInAdmin(stock, loggedUser);
                    } else {
                        auth.loggedInUser(stock, loggedUser);
                    }
                    break;
                case 2:
                    auth.createUser();
                    System.out.println("Registration successful! ✔︎");
                    break;
                case 0:
                    System.out.println("Hope to see you soon!");
                    return;
                default:
                    System.out.println("Please try again");
                    break;
            }
        }
    }
}