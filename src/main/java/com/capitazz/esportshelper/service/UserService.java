package com.capitazz.esportshelper.service;

import java.util.Collections;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.capitazz.esportshelper.model.security.Role;
import com.capitazz.esportshelper.model.security.User;
import com.capitazz.esportshelper.repository.UserRepository;

/**
 * Сервис для работы с пользователями {@link User}.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MailService mailService;

    public UserService(UserRepository userRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDb = loadUserByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);

        sendActivationCode(user);

        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);

        return true;
    }

    private void sendActivationCode(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                "Hello %s,\n" +
                    "Welcome to esports-helper!\n\n" +
                    "Please, verify your email by clicking the following link:\n" +
                    "http://localhost:8989/activate/%s",
                user.getUsername(),
                user.getActivationCode()
            );

            mailService.send(user.getEmail(), "Activation Code", message);
        }
    }
}
