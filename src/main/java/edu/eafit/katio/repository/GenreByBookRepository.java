package edu.eafit.katio.repository;

import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.dto.GenreByBook;

public interface GenreByBookRepository extends CrudRepository<GenreByBook, Long> {
    GenreByBook saveAndFlush(GenreByBook genre);
}
