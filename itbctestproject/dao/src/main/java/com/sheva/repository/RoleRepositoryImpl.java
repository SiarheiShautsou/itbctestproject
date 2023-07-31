package com.sheva.repository;

import com.sheva.domain.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepositoryInterface {

    private final EntityManagerFactory entityManagerFactory;


    @Override
    public Role findRoleByName(String name) {

        Role role = null;

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            role = entityManager.find(Role.class, name);

        }

        return role;
    }
}
