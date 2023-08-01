package com.sheva.controller.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserCreateRequest {

    @NotBlank(message = "Lastname must be filled")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,40}", message = "Lastname isn't valid")
    private String userLastName;

    @NotBlank(message = "Name must be filled")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,20}", message = "Name isn't valid")
    private String userName;

    @NotBlank(message = "Patronymic must be filled")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,40}", message = "Patronymic isn't valid")
    private String userPatronymic;

    @NotBlank(message = "Email must be filled")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
            message = "Email isn't valid")
    private String userEmail;

    @NotBlank(message = "Role must be filled")
//    @Pattern(regexp = "^[a-zA-Z0-9]{1,40}", message = "Role must be ADMINISTRATOR, SALE_USER, CUSTOMER_USER or SECURE_API_USER")
    private String userRole;

}
