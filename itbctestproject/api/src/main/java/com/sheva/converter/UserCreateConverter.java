package com.sheva.converter;

import com.sheva.controller.requests.UserCreateRequest;
import com.sheva.domain.User;
import com.sheva.repository.RoleRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserCreateConverter implements Converter<UserCreateRequest, User> {

    private final RoleRepositoryInterface roleRepository;

    @Override
    public User convert(UserCreateRequest source) {

        User user = new User();

        user.setLastName(source.getUserLastName());
        user.setName(source.getUserName());
        user.setPatronymic(source.getUserPatronymic());
        user.setEmail(source.getUserEmail());
        user.setRole(roleRepository.findRoleByName(source.getUserRole()));
        user.setCreationDate(new Timestamp(new Date().getTime()));
        user.setModificationDate(new Timestamp(new Date().getTime()));

        return user;
    }
}
