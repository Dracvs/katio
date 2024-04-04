package edu.eafit.katio.services;

import edu.eafit.katio.interfaces.BaseBookService;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repository.BookRepository;

public class BookService implements BaseBookService {

    private BookRepository _bookRepository;

    public BookService(BookRepository bookRepository){
        _bookRepository = bookRepository;
    }
    
    @Override
    public Iterable<Books> getAllBooks() {
        var bookList = _bookRepository.findAll();
        return bookList;
    }

    @Override
    public Iterable<Books> getAllBooksByAuthor(int idAuthor) {
       var booklist = _bookRepository.findByAuthorId(idAuthor);
       return booklist;
    }

    @Override
    public Iterable<Books> getAllBooksByAuthor(String Lastname) {
        var bookList = _bookRepository.findByAuthorLastName(Lastname);
        return bookList;
    }
    
}
