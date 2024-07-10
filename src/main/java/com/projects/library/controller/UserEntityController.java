package com.projects.library.controller;

import com.projects.library.dto.UserEntityDto;
import com.projects.library.model.UserEntity;
import com.projects.library.repository.CustomUserEntityDetails;
import com.projects.library.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserEntityController {

    private final UserService userService;

    public UserEntityController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showRegistrationForm(Model model){
        UserEntityDto user = new UserEntityDto();
        model.addAttribute("userEntity", user);
        return "signup";
    }

    @PostMapping("/signup/save")
    public String registerUser(@Valid @ModelAttribute("userEntity") UserEntityDto userEntityDto,
                               BindingResult result,
                               Model model) {
        UserEntity userByEmail = userService.findUserByEmail(userEntityDto.getEmail());
        UserEntity userByUsername = userService.findUserByUsername(userEntityDto.getUsername());

        if(userByEmail != null){
            result.rejectValue("email", null,
                    "The email already belongs to an account");
        }
        if(userByUsername != null){
            result.rejectValue("username",null,
                    "The username already belongs to an account");
        }
        if(result.hasErrors()){
            model.addAttribute("userEntity", userEntityDto);
            return "/signup";
        }
        userService.save(userEntityDto);
        return "redirect:/signup?success";
    }

    public String getCurrentUsername() {
        return ((CustomUserEntityDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }
}
