package com.capitazz.esportshelper.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capitazz.esportshelper.model.security.Role;
import com.capitazz.esportshelper.model.security.User;
import com.capitazz.esportshelper.repository.UserRepository;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("{userId}")
    public String userEditForm(@PathVariable("userId") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userForm";
    }


    @PostMapping
    public String userSave(@RequestParam("userId") User user, @RequestParam String username,
        @RequestParam Map<String, String> form) {

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

        return "redirect:/user";
    }

}
