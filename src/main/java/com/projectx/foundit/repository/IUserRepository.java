package com.projectx.foundit.repository;


import com.projectx.foundit.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByVerificationCode(String verificationCode);
    User findUserByEmail(String email);
    User findUserById(Integer id);
    User findUserByUsername(String username);
}
