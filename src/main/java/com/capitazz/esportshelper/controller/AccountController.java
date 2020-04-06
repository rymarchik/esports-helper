package com.capitazz.esportshelper.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capitazz.esportshelper.model.security.User;
import com.capitazz.esportshelper.repository.UserRepository;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Value("${upload.path}")
    private String uploadPath;

    private UserRepository userRepository;

    public AccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String accountSettings(@AuthenticationPrincipal User user, Model model) {
        User userFromDb = userRepository.findById(user.getId()).get();
        model.addAttribute("user", userFromDb);
        return "account";
    }

    @PostMapping
    public String saveAccountSettings(@RequestParam("userId") User user, @RequestParam MultipartFile avatar,
        @RequestParam String username, @RequestParam String password) throws IOException {

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
        userRepository.save(user);

        return "redirect:/account";
    }
}
