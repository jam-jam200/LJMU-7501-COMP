import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//a class representing a book with details
class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private final String publisher;
    private final int releaseYear;

    public Book(String title, String author, String isbn, String publisher, int releaseYear) {
        //constructor for creating a new Book object with the specified details
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
    }

    //getters for the book details
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        //generating a string representation of the book
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nPublisher: " + publisher + "\nRelease Year: " + releaseYear;
    }
}

public class BookProgram {
    public static void main(String[] args) {
        //creating an ArrayList to store the list of Book objects
        ArrayList<Book> bookList = new ArrayList<>();
        initializeBookList(bookList); //initializing the book list with sample books

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nThe Menu:");
            System.out.println("1. Display a book from a list");
            System.out.println("2. Sort the book list");
            System.out.println("3. Exit Program");
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter the index of the book to display (0-9): ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < bookList.size()) {
                        //check if the entered index is valid (within the range of available books(0-9))
                        System.out.println("\nBook Details:");
                        System.out.println(bookList.get(index)); //display details of the selected book
                    } else {
                        //in case the entered index is invalid print out error message
                        System.out.println("Invalid index. Please enter a valid index (0-9).");
                    }
                }
                case 2 -> {
                    sortBookList(bookList); // Sort the book list based on user's option
                    System.out.println("Booklist sorted.");
                }
                case 3 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please enter a valid option.");
            }
        }
    }

    // Initialize the book list with sample books
    private static void initializeBookList(ArrayList<Book> bookList) {
        bookList.add(new Book("Book 1", "Author 1", "ISBN 1111", "Publisher 1", 2020));
        bookList.add(new Book("Book 2", "Author 2", "ISBN 2222", "Publisher 2", 2019));
        bookList.add(new Book("Book 3", "Author 3", "ISBN 3333", "Publisher 3", 2018));
        bookList.add(new Book("Book 4", "Author 4", "ISBN 4444", "Publisher 4", 2017));
        bookList.add(new Book("Book 5", "Author 5", "ISBN 5555", "Publisher 5", 2016));
        bookList.add(new Book("Book 6", "Author 6", "ISBN 6666", "Publisher 6", 2015));
        bookList.add(new Book("Book 7", "Author 7", "ISBN 7777", "Publisher 7", 2014));
        bookList.add(new Book("Book 8", "Author 8", "ISBN 8888", "Publisher 8", 2013));
        bookList.add(new Book("Book 9", "Author 9", "ISBN 9999", "Publisher 9", 2012));
        bookList.add(new Book("Book 10", "Author 10", "ISBN 1010", "Publisher 10", 2011));
    }

    // Sort the book list based on user's choice
    private static void sortBookList(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSort Options:");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Author");
        System.out.println("3. Sort by ISBN");
        System.out.println("4. Sort by Publisher");
        System.out.println("5. Sort by Release Year");
        System.out.print("Enter your choice: ");
        int sortChoice = scanner.nextInt();

        Comparator<Book> comparator = null;

        switch (sortChoice) {
            case 1:
                comparator = Comparator.comparing(Book::getTitle);
                break;
            case 2:
                comparator = Comparator.comparing(Book::getAuthor);
                break;
            case 3:
                comparator = Comparator.comparing(Book::getIsbn);
                break;
            case 4:
                comparator = Comparator.comparing(Book::getPublisher);
                break;
            case 5:
                comparator = Comparator.comparingInt(Book::getReleaseYear);
                break;
            default:
                System.out.println("Invalid choice. The booklist remains unsorted.");
                return;
        }

        Collections.sort(bookList, comparator); // Sort the book list using the chosen comparator
    }
}
