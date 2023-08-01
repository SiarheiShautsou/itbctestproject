package com.sheva.converter;

import com.sheva.controller.responses.UserResponse;
import com.sheva.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserResponseConverter implements Converter<User, UserResponse> {
    @Override
    public UserResponse convert(User source) {

        UserResponse response = new UserResponse();

        String username = source.getLastName() + " " + source.getName() + " " + source.getPatronymic();
        response.setUserName(username);
        response.setEmail(source.getEmail());
        response.setRole(source.getRole().getRoleName());

        return response;
    }
}
