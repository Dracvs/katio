package edu.eafit.katio.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Books;
import edu.eafit.katio.models.BooksAuthors;
import edu.eafit.katio.dto.BookByAuthor;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.repository.BooksAuthorRepository;
import edu.eafit.katio.repository.BooksByAuthorRepository;
import edu.eafit.katio.services.BookService;
import edu.eafit.katio.services.BooksAuthorsService;


@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired
    private BooksByAuthorRepository _BooksByAuthorRepository;

    @Autowired 
    BooksAuthorRepository _BooksAuthorRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Books>> getAllBooks() {
        var books = new BookService(_bookRepository).getAllBooks();
        return new ResponseEntity<Iterable<Books>>(books, HttpStatus.OK);
    }

    @GetMapping("/getByAuthor")
    public ResponseEntity<Iterable<Books>> getAllBooksByAuthor(@RequestParam Integer id)
    {
        var response = new BookService(_bookRepository).getAllBooksByAuthor(id);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByAuthor/{name}/{lastname}")
    public ResponseEntity<Iterable<BookByAuthor>> getAllBookByAuthor(@PathVariable("name") String name, @PathVariable("lastname") String lastname)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthor(name, lastname);
        return new ResponseEntity<Iterable<BookByAuthor>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByAuthorNames")
    public ResponseEntity<Iterable<BookByAuthor>> getAllBooksByAuthorsName(@RequestBody Authors author) {
        
        //@TODO: ESTO NO HACE NADA. CORREGIR.
        var response = new ArrayList<BookByAuthor>();
        response.add(new BookByAuthor());
        return new ResponseEntity<Iterable<BookByAuthor>>(response, HttpStatus.OK);
    }

    @GetMapping("/getBooksByName")
    public ResponseEntity<Iterable<Books>> getBookByName(@RequestBody Books book) {
        var response = new BookService(_bookRepository).getBooksByName(book.getName());
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }
    
    @GetMapping("/getBooksByAuthor")
    public ResponseEntity<Iterable<BooksAuthors>> getBooksByAuthor(){
        var response = new BooksAuthorsService(_BooksAuthorRepository).getAllBooksAuthors();
        return new ResponseEntity<Iterable<BooksAuthors>>(response, HttpStatus.OK);
    }
    

    /**
     * 
     * Get All Books
     * get All Books By Author Name or Last name
     * Get All Books By Author ID
     * Create new Book
     * Edit Existing Book by ID
     * Search book by ISBN
     * Search Book by ISBN13
     * Search books by Date
     * Search books by Genre
     */
    
}
