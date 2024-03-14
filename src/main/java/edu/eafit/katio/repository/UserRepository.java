package edu.eafit.katio.repository;

import org.springframework.data.repository.CrudRepository;

import edu.eafit.katio.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    User saveAndFlush(User user);
}
