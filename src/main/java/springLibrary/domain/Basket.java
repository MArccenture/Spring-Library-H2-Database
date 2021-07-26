package springLibrary.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Basket {

    // private Set<Book> bookBasket = new HashSet<>();
    private @Id
    @GeneratedValue
    Long basketId;
    private String bookTitle;
    private String author;
    private String publisher;
    private int quantity;
    private double price;
    //   private Book bookId;
//    private Author authorId;


//    @JoinTable(name = "basket_book", joinColumns = @JoinColumn(name = "basket_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id"))
//    private Set<Book> books = new HashSet<>();

    public Basket() {
    }

    public Basket(String bookTitle, String author, String publisher, int quantity, double price) {

        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(bookTitle, basket.bookTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookTitle);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateBasketTotal(ArrayList<Basket> shoppingBasket){
        double total = 0;
        for (Basket items: shoppingBasket
             ) {
            total += items.price;

        }

        return total;
    }
}
