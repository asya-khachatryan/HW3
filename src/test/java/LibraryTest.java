import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    public void initialize(){
        library = new Library();
        book1 = new Book("Jane Austen", "Pride and Prejudice", "Romance");
        book2 = new Book("Stuart Turton","The Seven Deaths of Evelyn Hardcastle", "Mystery");
        book3 = new Book("Jane Austen", "Sense and Sensibility", "Drama");
    }

    @Test
    void addBook() {
        library.addBook(book1);
        assertEquals(1, library.getBooks().size());
        library.addBook(book1);
        assertEquals(1, library.getBooks().size());
        library.addBook(book2);
        assertEquals(2, library.getBooks().size());
    }

    @Test
    void removeBook() {
        library.addBook(book1);
        library.removeBook(book2);
        assertEquals(1, library.getBooks().size());
        library.removeBook(book1);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    void searchByAuthor() {
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> books = library.searchByAuthor("Jane Austen");

        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book3));

        books = library.searchByAuthor("Charlotte Brontë");
        assertEquals(0, books.size());
    }

    @Test
    void isAvailable() {
        library.addBook(book1);
        boolean available = library.isAvailable(book1);
        assertTrue(available);
        available = library.isAvailable(book2);
        assertFalse(available);
    }

    @Test
    void getBooks(){
        library.addBook(book1);
        List<Book> books = library.getBooks();

        List<Book> books1 = new ArrayList<>();
        books1.add(book1);

        assertEquals(books1, books);
    }
}