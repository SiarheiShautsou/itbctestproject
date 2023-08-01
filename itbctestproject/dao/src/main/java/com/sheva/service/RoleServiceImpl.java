package com.sheva.service;

import com.sheva.domain.Role;
import com.sheva.repository.RoleRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleServiceInterface {

    private final RoleRepositoryInterface roleRepository;

    @Override
    public Role getRoleByName(String name) {


        return roleRepository.findRoleByName(name);

    }
}
