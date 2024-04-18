package edu.eafit.katio.interfaces;

import edu.eafit.katio.dto.BookByAuthor;
import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getAllBooksByAuthor(int idAuthor);
    Iterable<BookByAuthor> getAllBooksByAuthor(String Name, String Lastname);
}
