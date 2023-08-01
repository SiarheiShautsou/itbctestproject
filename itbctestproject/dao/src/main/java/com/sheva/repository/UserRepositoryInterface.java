package com.sheva.repository;

import com.sheva.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {

    Optional<User> findById(Integer id);

    List<User> findAll();

    void saveUser(User user);

    void updateUserInfo(User user);

    void deleteUser(User user);


}
