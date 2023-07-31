package com.sheva.repository;

import com.sheva.domain.Role;

public interface RoleRepositoryInterface {

    Role findRoleByName(String name);
}
