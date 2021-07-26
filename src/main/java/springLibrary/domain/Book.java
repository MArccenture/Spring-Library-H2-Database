package springLibrary.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//@Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.
@Entity
public class Book {

    private @Id @GeneratedValue Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private int publicationYear;
    private int quantity;
    private double price;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    //An empty constructor is needed to create a new instance via reflection by your persistence
    // framework.
    // If you don't provide any additional constructors with arguments for the class, you don't need
    // to provide an empty constructor because you get one per default.
    Book(){}

    public Book(String bookTitle, String bookAuthor, int publicationYear, int quantity, double price){
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return this.bookTitle + " " + this.bookAuthor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.bookTitle = parts[0];
        this.bookAuthor = parts[1];
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                '}';
    }
}
