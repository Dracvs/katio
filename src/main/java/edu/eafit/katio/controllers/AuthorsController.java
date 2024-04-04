package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/katio/authors")
public class AuthorsController {
    @Autowired
    private AuthorRepository _authorRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Authors>> getAllAuthors() {
        var authors = _authorRepository.findAll();
        return new ResponseEntity<Iterable<Authors>>(authors, HttpStatus.OK);
    }
    
}
