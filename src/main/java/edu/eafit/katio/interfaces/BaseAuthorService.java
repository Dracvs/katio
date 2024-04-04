package edu.eafit.katio.interfaces;

import edu.eafit.katio.models.Authors;

public interface BaseAuthorService {
    Iterable<Authors> getAllAuthors();
}
