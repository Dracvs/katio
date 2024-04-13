package edu.eafit.katio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookByAuthor {
    
    @Id
    @Column(name="id_book")
    private long IdBook;

    @Column(name="book_name")
    private String BookName;

    @Column(name="isbn13")
    private String ISBN13;

    @Column(name="Author_Name")
    private String Author;

    public long getIdBook() {
        return IdBook;
    }

    public void setIdBook(long idBook) {
        IdBook = idBook;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getISBN13() {
        return ISBN13;
    }

    public void setISBN13(String iSBN13) {
        ISBN13 = iSBN13;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}