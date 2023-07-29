package com.sheva.domain;

import lombok.Data;

@Data
public class User {

    private String lastName;

    private String name;

    private String patronymic;

    private String email;

    private Role role;
}
