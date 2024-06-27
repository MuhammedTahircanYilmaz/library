package com.projects.library.controller;

import com.projects.library.dto.UserEntityDto;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model){
        UserEntityDto user = new UserEntityDto();
        model.addAttribute("userEntity", user);
        return "login";
    }

}
