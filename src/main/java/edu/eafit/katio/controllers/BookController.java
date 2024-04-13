package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.BookByAuthor;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.repository.BooksByAuthorRepository;
import edu.eafit.katio.services.BookService;


@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired
    private BooksByAuthorRepository _BooksByAuthorRepository;

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
    
}
