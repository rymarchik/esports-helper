package com.capitazz.esportshelper.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capitazz.esportshelper.model.security.Role;
import com.capitazz.esportshelper.model.security.User;
import com.capitazz.esportshelper.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        user.setRoles(Collections.singleton(Role.GUEST));

        validateBeanProperties(user, bindingResult, model);
        validateDuplicates(user, model);

        if (ControllerUtils.containsAnyError(model)) {
            return "registration";
        }

        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activateUser(@PathVariable String code, Model model) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Verification successful!");
        }
        else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }

    private void validateBeanProperties(User user, BindingResult bindingResult, Model model) {
        if (user.getPassword() != null && !user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords are different");
        }
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
        }
    }

    private void validateDuplicates(User user, Model model) {
        if (userService.userExistsWithUsername(user.getUsername())) {
            model.addAttribute("usernameError", "User with the same username already exists");
        }
        if (userService.userExistsWithEmail(user.getEmail())) {
            model.addAttribute("emailError", "User with the same email already exists");
        }
    }
}
