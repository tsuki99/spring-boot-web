package mate.academy.springbootweb;

import java.math.BigDecimal;
import mate.academy.springbootweb.model.Book;
import mate.academy.springbootweb.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWebApplication {
    private final BookService bookService;

    public SpringBootWebApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("Test book");
            book.setAuthor("Anyone");
            book.setIsbn("111-222-333");
            book.setPrice(BigDecimal.valueOf(100));
            book.setDescription("Any description");
            bookService.save(book);
            System.out.println("Book has been saved! Books exist: "
                    + bookService.findAll().size());
        };
    }
}
