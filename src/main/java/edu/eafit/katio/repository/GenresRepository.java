package edu.eafit.katio.repository;

import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.Genres;

public interface GenresRepository extends CrudRepository<Genres, Long> {
    Genres saveAndFlush(Genres genre);
}
