import java.util.ArrayList;
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
                    //sorting the book list based on user's option
                    sortBookList(bookList);
                    System.out.println("Booklist sorted.");
                }
                case 3 -> {
                    //exiting the program
                    System.out.println("Exiting program.");
                    //closing the scanner to release resources associated with standard input (System.in)
                    scanner.close();
                    System.exit(0);
                }
                //in case the entered option is invalid print out error message
                default -> System.out.println("Invalid option. Please enter a valid option.");
            }
        }
    }

    //initializing the book list with sample books
    private static void initializeBookList(ArrayList<Book> bookList) {
        bookList.add(new Book("Book A", "Author J", "ISBN 11112", "Publisher A", 2023));
        bookList.add(new Book("Book B", "Author I", "ISBN 2223", "Publisher B", 2022));
        bookList.add(new Book("Book C", "Author H", "ISBN 3334", "Publisher C", 2021));
        bookList.add(new Book("Book D", "Author G", "ISBN 4445", "Publisher D", 2020));
        bookList.add(new Book("Book E", "Author F", "ISBN 5556", "Publisher E", 2019));
        bookList.add(new Book("Book F", "Author E", "ISBN 6667", "Publisher F", 2018));
        bookList.add(new Book("Book G", "Author D", "ISBN 7778", "Publisher G", 2017));
        bookList.add(new Book("Book H", "Author C", "ISBN 8889", "Publisher H", 2016));
        bookList.add(new Book("Book I", "Author B", "ISBN 9910", "Publisher I", 2015));
        bookList.add(new Book("Book J", "Author A", "ISBN 1011", "Publisher J", 2014));
    }

    //sorting the book list based on the user's option
    private static void sortBookList(ArrayList<Book> bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSort Options:");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Author");
        System.out.println("3. Sort by ISBN");
        System.out.println("4. Sort by Publisher");
        System.out.println("5. Sort by Release Year");
        System.out.print("Enter your Option: ");
        int sortOption = scanner.nextInt();

        //initializing a Comparator for sorting the books, initially set to null because of no set sortOption
        Comparator<Book> comparator = null;

        switch (sortOption) {
            case 1 ->
                //sort the book list by title
                    comparator = Comparator.comparing(Book::getTitle);
            case 2 ->
                //sort the book list by author
                    comparator = Comparator.comparing(Book::getAuthor);
            case 3 ->
                //sort the book list by ISBN
                    comparator = Comparator.comparing(Book::getIsbn);
            case 4 ->
                //sort the book list by publisher
                    comparator = Comparator.comparing(Book::getPublisher);
            case 5 ->
                //sort the book list by release year
                    comparator = Comparator.comparingInt(Book::getReleaseYear);
            default -> {
                //in case the entered option is invalid print out error message
                System.out.println("Invalid option. The book list remains unsorted.");
                return;
            }
        }

        bookList.sort(comparator); //sort the book list using the chosen comparator(the one chosen by the user)
    }
}
