package edu.eafit.katio.interfaces;

import edu.eafit.katio.models.BookByAuthor;
import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getAllBooksByAuthor(int idAuthor);
    Iterable<BookByAuthor> getAllBooksByAuthor(String Name, String Lastname);
}
