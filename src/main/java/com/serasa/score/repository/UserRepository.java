package com.serasa.score.repository;

import com.serasa.score.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
