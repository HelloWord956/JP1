import Entity.Author;
import Entity.Book;
import Entity.Gender;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("John", Gender.M, "John@gmail.com"));
        authors.add(new Author("Jane", Gender.F, "Jane@gmail.com"));
        authors.add(new Author("Bob", Gender.M, "Bob@gmail.com"));

        List<Book> books = new ArrayList<>();
        books.add(new Book("Hello", authors.get(0), 10.0, 1 ));
        books.add(new Book("Use brain", authors.get(0), 11.0, 1 ));
        books.add(new Book("You are my love", authors.get(1), 12.0, 1 ));
        books.add(new Book("A monster in your home", authors.get(1), 14.0, 1 ));
        books.add(new Book("World", authors.get(1), 15.0, 2 ));
        books.add(new Book("I'm Learning java", authors.get(2), 20.0, 3 ));
        books.add(new Book("There is nothing", authors.get(2), 22.5, 4 ));

        // Using Stream API sort Book by name
        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparing(Book::getName))
                .toList();

        sortedBooks.forEach(book -> System.out.println(book));

        //Show info of Book has max price
        Optional<Book> maxPriceBook = books.stream()
                .max(Comparator.comparing(Book::getPrice));
        if (maxPriceBook.isPresent()) {
            System.out.println("\nThe book with max price is: " + maxPriceBook.get());
        }

        // Listing Book of author by name input via scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter the authorize: ");
        String authorName = sc.nextLine();

        List<Book> booksByAuthor = books.stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());

        if(booksByAuthor.isEmpty()) {
            System.out.println("No books found");
        } else {
            System.out.println(booksByAuthor);
        }
    }
}