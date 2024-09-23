import Entity.Author;
import Entity.Book;
import Entity.Gender;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("John", Gender.M, "John@gmail.com"));
        authors.add(new Author("Jane", Gender.F, "Jane@gmail.com"));
        authors.add(new Author("Bob", Gender.M, "Bob@gmail.com"));

        List<Book> books = new ArrayList<>();
        books.add(new Book("Hello", authors.get(0), 10.0, 1 ));
        books.add(new Book("World", authors.get(1), 15.0, 2 ));
        books.add(new Book("I'm Learning java", authors.get(2), 20.0, 3 ));

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
    }
}