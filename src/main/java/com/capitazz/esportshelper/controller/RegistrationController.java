package com.capitazz.esportshelper.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capitazz.esportshelper.model.security.Role;
import com.capitazz.esportshelper.model.security.User;
import com.capitazz.esportshelper.repository.UserRepository;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String registerUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("errorMessage", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }

}
