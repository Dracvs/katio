package edu.eafit.katio.interfaces;

import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getAllBooksByAuthor(int idAuthor);
    Iterable<Books> getAllBooksByAuthor(String Lastname);
}
