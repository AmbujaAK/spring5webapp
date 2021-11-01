package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ambuj = new Author("Ambuj", "Kumar");
        Book ddd = new Book("Domain Driven Design", "123123");

        ambuj.getBooks().add(ddd);
        ddd.getAuthors().add(ambuj);

        authorRepository.save(ambuj);
        bookRepository.save(ddd);

        Author raju = new Author("Raju", "Kumar");
        Book tdd = new Book("Test Driven Design", "123123");

        raju.getBooks().add(ddd);
        tdd.getAuthors().add(ambuj);

        authorRepository.save(raju);
        bookRepository.save(tdd);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());


    }
}
