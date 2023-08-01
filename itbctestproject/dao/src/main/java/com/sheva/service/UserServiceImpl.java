package com.sheva.service;

import com.sheva.domain.User;
import com.sheva.exception.CommonException;
import com.sheva.repository.UserRepositoryInterface;
import com.sheva.util.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    private final UserRepositoryInterface userRepository;


    @Override
    public User getUserById(Integer id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else
            throw new CommonException(String.format("User with id = %d not found", id),
                    404,
                    UUIDGenerator.generateUUID());

    }

    @Override
    public List<User> searchUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {

        userRepository.saveUser(user);

    }

    @Override
    public void updateAllUserInfo(User user) {

        if (getUserById(user.getId()) != null) {

            userRepository.updateUserInfo(user);
        }
    }

    @Override
    public void deleteUser(User user) {

        if (getUserById(user.getId()) != null) {

            userRepository.deleteUser(user);
        }

    }
}
