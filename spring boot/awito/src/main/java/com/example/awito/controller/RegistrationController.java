package com.example.awito.controller;

import com.example.awito.entity.Role;
import com.example.awito.entity.User;
import com.example.awito.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String findUser(User user,
                           Model model){

        User usernameFromDb = userRepo.findByUsername(user.getUsername());

        if (usernameFromDb != null){
            model.addAttribute("message","Имя занятно");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/authentication";
    }




}
