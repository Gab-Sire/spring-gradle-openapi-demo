package net.gabsire087.springgradleopenapidemo.api.v1.controller;

import net.gabsire087.springgradleopenapidemo.api.v1.BooksApi;
import net.gabsire087.springgradleopenapidemo.api.v1.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-29T12:12:08.613-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.demoBook.base-path:}")
public class BooksApiController implements BooksApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BooksApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Book>> booksGet() {
        return null;
    }

    @Override
    public ResponseEntity<Book> booksIdGet(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> booksPost(@Valid Book book) {
        return null;
    }

}
