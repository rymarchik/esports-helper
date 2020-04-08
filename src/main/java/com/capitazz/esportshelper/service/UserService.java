package com.capitazz.esportshelper.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capitazz.esportshelper.model.security.Role;
import com.capitazz.esportshelper.model.security.User;
import com.capitazz.esportshelper.repository.UserRepository;

/**
 * Сервис для работы с пользователями {@link User}.
 */
@Service
public class UserService implements UserDetailsService {

    @Value("${upload.path}")
    private String uploadPath;

    private UserRepository userRepository;
    private MailService mailService;

    public UserService(UserRepository userRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean registerUser(User user) {
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

    private void sendActivationCode(User user) {
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

    public void updateUserProfile(User user, MultipartFile avatar, String username, String password, String email)
        throws IOException {

        if (!avatar.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uploadFilename = UUID.randomUUID().toString() + "-" + avatar.getOriginalFilename();
            avatar.transferTo(new File(uploadPath + "/" + uploadFilename));
            user.setAvatar(uploadFilename);
        }

        if (!username.isEmpty()) {
            user.setUsername(username);
        }
        if (!password.isEmpty()) {
            user.setPassword(password);
        }

        boolean isEmailChanged = !email.isEmpty() && !email.equals(user.getEmail());
        if (isEmailChanged) {
            user.setEmail(email);
            user.setActive(false);
            user.setActivationCode(UUID.randomUUID().toString());
        }

        userRepository.save(user);

        if (isEmailChanged) {
            sendActivationCode(user);
        }
    }

    public void updateUserRoles(User user, String username, Map<String, String> form) {
        Set<String> stringRoles = Arrays.stream(Role.values())
            .map(Role::name)
            .collect(Collectors.toSet());

        stringRoles.retainAll(form.keySet());

        Set<Role> roles = stringRoles.stream()
            .map(Role::valueOf)
            .collect(Collectors.toSet());

        user.setUsername(username);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
