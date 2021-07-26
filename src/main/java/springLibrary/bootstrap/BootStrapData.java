package springLibrary.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springLibrary.domain.Author;
import springLibrary.domain.Basket;
import springLibrary.domain.Book;
import springLibrary.domain.Publisher;
import springLibrary.repositories.AuthorRepository;
import springLibrary.repositories.BasketRepository;
import springLibrary.repositories.BookRepository;
import springLibrary.repositories.PublisherRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final BasketRepository basketRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, BasketRepository basketRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.basketRepository = basketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author herman = new Author("Herman", "Miller");
        Book moby = new Book("Moby Dick", "HermanMiller", 1899, 1,10.0);
        Publisher penguin = new Publisher("Penguin", "New York");
        publisherRepository.save(penguin);
        herman.getBooks().add(moby);
        moby.getAuthors().add(herman);
        moby.setPublisher(penguin);

        authorRepository.save(herman);
        bookRepository.save(moby);
        publisherRepository.save(penguin);

        Author ernest = new Author("Ernest", "Hemingway");
        Book fiesta = new Book("Fiesta", "EarnestHemingway", 1901, 1,15.00);
        ernest.getBooks().add(fiesta);
        fiesta.getAuthors().add(herman);
        fiesta.setPublisher(penguin);

        authorRepository.save(ernest);
        bookRepository.save(fiesta);
        publisherRepository.save(penguin);

        Basket basket = new Basket("Ritle", "Rauther", "Publisher", 1, 10);
        basketRepository.save(basket);
        Basket basket2 = new Basket("Ritle2", "Rauther2", "Publisher", 1, 5);
        basketRepository.save(basket2);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Books stored: " + bookRepository.findAll());
        System.out.println("Authors stored: " + authorRepository.findAll());
        System.out.println("Publishers number of books: " + penguin.getBooks().size());
    }
}
