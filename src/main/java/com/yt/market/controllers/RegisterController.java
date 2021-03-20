package com.yt.market.controllers;

import com.yt.market.entities.User;
import com.yt.market.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class RegisterController {
    private UserService userService;

    @GetMapping
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping
    public String confirmRegister(@ModelAttribute User user) {
        User u = userService.findByUsername(user.getUsername());
        if (u == null){
            userService.save(user);
            return "redirect:/products";
        }
        return "register";
    }
}
