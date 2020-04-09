package com.capitazz.esportshelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitazz.esportshelper.model.security.User;

/**
 * Репозиторий для работы с пользователями {@link User}.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findByActivationCode(String code);
}
