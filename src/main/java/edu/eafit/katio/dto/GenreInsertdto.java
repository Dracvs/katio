package edu.eafit.katio.dto;

import java.util.ArrayList;

import edu.eafit.katio.models.Genres;

public class GenreInsertdto {
    Long BookId;
    ArrayList<Genres> GenreList;

    public ArrayList<Genres> getGenreList() {
        return GenreList;
    }

    public void setGenreList(ArrayList<Genres> genreList) {
        GenreList = genreList;
    }

    public Long getBookId() {
        return BookId;
    }

    public void setBookId(Long bookId) {
        BookId = bookId;
    }
}
