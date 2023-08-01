package com.sheva.repository;

import com.sheva.domain.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepositoryInterface {

    private final EntityManagerFactory entityManagerFactory;


    @Override
    public Role findRoleByName(String name) {

        Role role = null;

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            TypedQuery<Role> query = entityManager.createQuery("select r from Role r where roleName = :param", Role.class);
            query.setParameter("param", name);
            role = query.getSingleResult();

        }

        return role;
    }
}
