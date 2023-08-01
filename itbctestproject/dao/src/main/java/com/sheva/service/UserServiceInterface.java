package com.sheva.service;

import com.sheva.domain.User;

import java.util.List;

public interface UserServiceInterface {

    User getUserById(Integer id);

    List<User> searchUsers();

    void createUser(User user);

    void updateAllUserInfo(User user);

    void deleteUser(User user);


}
