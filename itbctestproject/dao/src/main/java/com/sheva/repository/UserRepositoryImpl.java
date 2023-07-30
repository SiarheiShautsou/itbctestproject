package com.sheva.repository;

import com.sheva.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Primary
public class UserRepositoryImpl implements UserRepositoryInterface{

    private final EntityManagerFactory entityManagerFactory;
    @Override
    public Optional<User> findById(Integer id) {

        User userById;

        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){

            userById = entityManager.createQuery("select u from User u where u.id = id", User.class).getSingleResult();

        }

        return Optional.of(userById);
    }

    @Override
    public List<User> findAll() {

        List<User> users;

        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            users = entityManager.createQuery("select u from User u", User.class).getResultList();
        }
        return users;
    }
}
