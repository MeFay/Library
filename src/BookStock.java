import java.util.*;

public class BookStock {

    static List<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Adding a new book to the stock
    public void addBook() {
        System.out.println("📖 Which book do you want to add? 📖\n ");
        System.out.print("Enter the Title: ");
        String title = sc.nextLine();
        System.out.print("Enter the Author: ");
        String author = sc.nextLine();
        System.out.print("Enter the Year: ");
        int year = Integer.parseInt(sc.nextLine());
        new Book(title, author, year);
    }

    // Creating a new Book object with the provided information and add it to the stock
    public void addBook(Book book) {
        books.add(book);
    }

    // Retrieving the list of books in the stock
    public List<Book> getBooks() {
        return books;
    }

    // Finding a book by its title and display the information
    public static Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                System.out.println(book.info());
            }
        }
        return null;
    }

    // Finding a book by its author and display the information
    public static Book findBookByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                System.out.println(book.info());
            }
        }
        return null;
    }

    // Search for a book based on user's choice (title or author)
    public static void findBook() {
        System.out.println("Do you want to search by: 1・Title  2・Author \n Option: ");
        int searchChoice = sc.nextInt();
        switch (searchChoice) {
            case 1:
                System.out.println("Whats the title you're looking for? ");
                String title = sc.nextLine();
                title = sc.nextLine();
                findBookByTitle(title);
                break;
            case 2:
                System.out.println("Whats the author you're looking for? ");
                String author = sc.nextLine();
                author = sc.nextLine();
                findBookByAuthor(author);
                break;
        }
    }

    // Display the book stock, sorted by title
    public void booksStock(User loggedUser) {
        books = books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
        System.out.println("\n∯∯∯∯∯∯∯∯∯∯∯∯∯∯∯∯");
        for (Book book : books) {
            System.out.println("Tile: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Year: " + book.getYear());
            if (loggedUser.isAdmin() && book.isBeingBorrowed()) {
                System.out.println("User: " + book.getUserBorrowed().getUsername());
            }
            System.out.println("\n∯∯∯∯∯∯∯∯∯∯∯∯∯∯∯∯");
        }

        //for (int i = 0; i < books.size(); i++) {
        //    System.out.print((i + 1) + " Title: " + books.get(i).getAuthor() +
        //            " || Author: " + books.get(i).getAuthor() +
        //            " || Year: " + books.get(i).getYear() + " || Borrowed: ");
        //    System.out.print(books.get(i).isBeingBorrowed() ? "Sim" : "Nao");

        //    if (loggedUser.isAdmin() &&  books.get(i).isBeingBorrowed()){
        //        System.out.println("User: ");
        //        System.out.println(books.get(i).getUsernameBorrowed().getUsername());
        //    }
        //}
    }

    public void borrower(Book book, User user) {

    }


}


