package com.sheva.service;

import com.sheva.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserServiceInterface {

    User getUserById(Integer id);

    List<User> searchUsers();

    void createUser(User user);

    void updateAllUserInfo(User user);

    void deleteUser(User user);


}
