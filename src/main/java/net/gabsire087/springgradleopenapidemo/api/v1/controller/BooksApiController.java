package net.gabsire087.springgradleopenapidemo.api.v1.controller;

import net.gabsire087.springgradleopenapidemo.api.v1.BooksApi;
import net.gabsire087.springgradleopenapidemo.api.v1.model.Book;
import net.gabsire087.springgradleopenapidemo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-29T12:12:08.613-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.demoBook.base-path:}")
public class BooksApiController implements BooksApi {

    // goes around the @Autowired annotation for now as we don't need it
    private BookService bookService = new BookService();

    /**
     * GET method for a list of books information
     * @return OK response with a list of books if successful
     */
    @Override
    public ResponseEntity<List<Book>> booksGet() {
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    /**
     * GET method to find a particular book by its id
     * @param id  (required) UUID
     * @return OK response if successful, the book if found
     */
    @Override
    public ResponseEntity<Book> booksIdGet(UUID id) {
        Book book = bookService.getBookById(id);

        if(null == book){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    /**
     * POST method to add a book to the collection
     * @param book  (required) Book
     * @return CREATED response if successful
     */
    @Override
    public ResponseEntity<Void> booksPost(@Valid Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
