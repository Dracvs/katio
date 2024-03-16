package edu.eafit.katio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Book;

@RestController
@RequestMapping("/katio/books")
public class BooksController {
    
    @GetMapping("/getall")
    public ResponseEntity<Book> getAll(){
        return new ResponseEntity<Book>(new Book(), HttpStatus.OK);
    }
}
