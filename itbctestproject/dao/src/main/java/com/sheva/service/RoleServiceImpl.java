package com.sheva.service;

import com.sheva.domain.Role;
import com.sheva.domain.SystemRole;
import com.sheva.exception.CommonException;
import com.sheva.repository.RoleRepositoryInterface;
import com.sheva.util.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleServiceInterface {

    private final RoleRepositoryInterface roleRepository;

    @Override
    public Role getRoleByName(String name) {

        SystemRole role = null;
        String uc = name.toUpperCase();

        switch (SystemRole.valueOf(uc)) {
            case ADMINISTRATOR -> role = SystemRole.ADMINISTRATOR;
            case SALE_USER -> role = SystemRole.SALE_USER;
            case CUSTOMER_USER -> role = SystemRole.CUSTOMER_USER;
            case SECURE_API_USER -> role = SystemRole.SECURE_API_USER;
        }

        if (role != null) {
            return roleRepository.findRoleByName(uc);
        } else
            throw new CommonException(String.format("Role %s isn't exist", name),
                    404,
                    UUIDGenerator.generateUUID());

    }
}
