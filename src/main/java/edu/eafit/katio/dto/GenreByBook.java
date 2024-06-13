package edu.eafit.katio.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Books_Genres")
public class GenreByBook {
    
    @Id
    @Column(name="Book_Id")
    Long Bookid;
    @Column(name="Genre_id")
    Long GenreId;
    public Long getBookid() {
        return Bookid;
    }
    public void setBookid(Long bookid) {
        Bookid = bookid;
    }
    public Long getGenreId() {
        return GenreId;
    }
    public void setGenreId(Long genreId) {
        GenreId = genreId;
    }
}
