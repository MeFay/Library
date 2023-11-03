public class Book {
    private String title;
    private String author;
    private int year;
    private User userBorrowed;

    // Constructor to create a new Book with the title, author, and year
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.userBorrowed = null; // The book is not borrowed by any user by default

        // Adding the new created book to the static list of books in the BookStock class
        BookStock.books.add(this);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // Checking if the book is currently being borrowed by a user
    public boolean isBeingBorrowed() {
        return this.userBorrowed != null;
    }

    // Getter method to retrieve the user who borrowed the book
    public User getUserBorrowed() {
        return userBorrowed;
    }

    // Set the user who borrowed the book
    public void setBorrowed(User userBorrowed) {
        this.userBorrowed = userBorrowed;
    }

    public String info() {
        return "Title: " + this.title + "| Author: " + this.author;
    }
}
