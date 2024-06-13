package edu.eafit.katio.services;

import java.util.ArrayList;

import edu.eafit.katio.dto.BookByAuthor;
import edu.eafit.katio.dto.GenreByBook;
import edu.eafit.katio.dto.GenreInsertdto;
import edu.eafit.katio.interfaces.BaseBookService;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.repository.BooksByAuthorRepository;
import edu.eafit.katio.repository.GenreByBookRepository;
import edu.eafit.katio.repository.GenresRepository;

public class BookService implements BaseBookService {

    private BookRepository _bookRepository;
    private BooksByAuthorRepository _BooksByAuthorRepository;
    private GenresRepository _genresRepository;
    private GenreByBookRepository _genreByBookRepository;

    public BookService(BookRepository bookRepository){
        _bookRepository = bookRepository;
    }

    public BookService(BooksByAuthorRepository booksByAuthorRepository){
        _BooksByAuthorRepository = booksByAuthorRepository;
    }

    public BookService(BookRepository bookRepository, GenreByBookRepository genreByBookRepository){
        _bookRepository = bookRepository;
        _genreByBookRepository = genreByBookRepository;
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
    public Iterable<BookByAuthor> getAllBooksByAuthor(String Name, String Lastname) {
        
        Iterable<BookByAuthor> bookList = new ArrayList<BookByAuthor>();
        
        if(Lastname.length() > 0 && Name.length() <= 0)
        {
            bookList = _BooksByAuthorRepository.findByAuthorLastName(Lastname);
            
        }
        else if(Lastname.length() <= 0 && Name.length() > 0)
        {
            bookList = _BooksByAuthorRepository.findByAuthorName(Name);
        }
        else 
        {
            bookList = _BooksByAuthorRepository.findByAuthorFullName(Lastname, Name);
        }
        
        return bookList;
    }

    @Override
    public Iterable<Books> getBooksByName(String Name) {
        var bookList = _bookRepository.findByName(Name);
        return bookList;
    }

    @Override
    public Books addBook(Books book) {
        var newBook = _bookRepository.save(book);
        return newBook;
    }

    @Override
    public boolean addGenre(GenreInsertdto genreInsertdto) {
        var book = _bookRepository.findById(genreInsertdto.getBookId());
        if(book.isEmpty()){
            return false;
        }

        for (var item : genreInsertdto.getGenreList()) {
            var genre = new GenreByBook();
            genre.setBookid(book.get().getId());
            genre.setGenreId(item.getId());
            _genreByBookRepository.saveAndFlush(genre);
        }

        return true;
    }
    
}
