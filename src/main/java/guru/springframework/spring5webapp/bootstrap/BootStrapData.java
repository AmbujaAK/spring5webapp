package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Gaya");
        publisher.setState("Bihar");

        publisherRepository.save(publisher);


        Author ambuj = new Author("Ambuj", "Kumar");
        Book ddd = new Book("Domain Driven Design", "123123");

        ambuj.getBooks().add(ddd);
        ddd.getAuthors().add(ambuj);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(ambuj);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author raju = new Author("Raju", "Kumar");
        Book tdd = new Book("Test Driven Design", "123123");

        raju.getBooks().add(ddd);
        tdd.getAuthors().add(ambuj);

        tdd.setPublisher(publisher);
        publisher.getBooks().add(tdd);


        authorRepository.save(raju);
        bookRepository.save(tdd);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Publisher Number of Books : " + publisher.getBooks().size());


    }
}
