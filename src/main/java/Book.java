public class Book {
    private String author;
    private String name;
    private String genre;
    private boolean available;

    public Book(String author, String name, String genre) {
        this.author = author;
        this.name = name;
        this.genre = genre;
        this.available = true;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }
}
