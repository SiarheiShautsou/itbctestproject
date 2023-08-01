package com.sheva.controller;

import com.sheva.controller.requests.UserCreateRequest;
import com.sheva.controller.responses.UserResponse;
import com.sheva.domain.User;
import com.sheva.service.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceInterface userService;

    private final ConversionService converter;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findUserById(@PathVariable String id) {

        int userId = Integer.parseInt(id);

        User user = userService.getUserById(userId);

        UserResponse response = converter.convert(user, UserResponse.class);

        return new ResponseEntity<>(Collections.singletonMap("user", response), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<UserResponse>> findAllUsers() {

        List<User> users = userService.searchUsers();
        List<UserResponse> responseUsers = new ArrayList<>();
        for (User user : users) {
            responseUsers.add(converter.convert(user, UserResponse.class));
        }

        Page<UserResponse> responsePage = new PageImpl<>(responseUsers);

        return new ResponseEntity<>(responsePage, HttpStatus.OK);
    }

    @PostMapping
    public void createNewUser(UserCreateRequest request) {

//        validationUtils.validationRequest(request);

        User user = converter.convert(request, User.class);

        userService.createUser(user);

    }

}
