package edu.eafit.katio.services;

import edu.eafit.katio.interfaces.BaseAuthorService;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.repository.AuthorRepository;

public class AuthorService implements BaseAuthorService {

    private AuthorRepository _AuthorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        _AuthorRepository = authorRepository;
    }

    @Override
    public Iterable<Authors> getAllAuthors() {
        var authorList = _AuthorRepository.findAll();
        return authorList;
    }
    
}
