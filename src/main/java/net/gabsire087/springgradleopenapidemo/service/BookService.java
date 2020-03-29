package net.gabsire087.springgradleopenapidemo.service;

import net.gabsire087.springgradleopenapidemo.api.v1.model.Author;
import net.gabsire087.springgradleopenapidemo.api.v1.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    // instead of repository
    private List<Book> books;

    /**
     * Constructor of service, initialize some data to show for the demo
     */
    public BookService(){
        books = new ArrayList<>();
        initializeBooks();
    }

    public List<Book> getBooks(){
        return books;
    }

    public Book getBookById(UUID id){
        return books.stream().filter(book -> book.getId().equals(id)).findAny().orElse(null);
    }

    public void addBook(Book book){
        books.add(book);
    }

    private void initializeBooks() {

        Author author1 = new Author();
        author1.setAuthorFirstName("Howard");
        author1.setAuthorLastName("Philip Lovecraft");
        author1.setAuthorEmail("hplovecraft@online.net");

        Author author2 = new Author();
        author2.setAuthorFirstName("William");
        author2.setAuthorLastName("Gibson");
        author2.setAuthorEmail("cyberpunk@shop");

        final Book book1 = new Book();
        book1.setId(UUID.randomUUID());
        book1.setTitle("The Dunwich Horror");
        book1.setGenre(Book.GenreEnum.HORROR);
        book1.setAuthor(author1);
        book1.setPublishedDate("1929-04-01");

        final Book book2 = new Book();
        book2.setId(UUID.randomUUID());
        book2.setTitle("The Neuromancer");
        book2.setGenre(Book.GenreEnum.SCIFI);
        book2.setAuthor(author2);

        books.addAll(Arrays.asList(book1, book2));
    }
}
