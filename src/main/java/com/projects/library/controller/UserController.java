package com.projects.library.controller;

import com.projects.library.model.UserEntity;
import com.projects.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    @GetMapping("/signup")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserEntity(null, "","", ""));
        return "register";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute UserEntity userEntity) {
        userService.save(userEntity);
        return "redirect:/login";
    }
}
