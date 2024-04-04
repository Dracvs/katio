package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Books;
import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.services.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/katio/books")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

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

    @GetMapping("/getByAuthor/{lastname}")
    public ResponseEntity<Iterable<Books>> getAllBookByAuthor(@PathVariable("lastname") String lastname)
    {
        var response = new BookService(_bookRepository).getAllBooksByAuthor(lastname);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }
    
}
