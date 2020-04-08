package com.capitazz.esportshelper.controller;

import java.io.IOException;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capitazz.esportshelper.model.security.User;
import com.capitazz.esportshelper.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

    private UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String accountProfile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("avatar", user.getAvatar());
        return "account";
    }

    @PostMapping
    public String updateAccountProfile(@AuthenticationPrincipal User user, @RequestParam MultipartFile avatar,
        @RequestParam String username, @RequestParam String password, @RequestParam String email) throws IOException {

        userService.updateUserProfile(user, avatar, username, password, email);
        return "redirect:/account";
    }
}
