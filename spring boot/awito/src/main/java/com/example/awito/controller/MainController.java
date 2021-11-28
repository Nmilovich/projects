package com.example.awito.controller;

import com.example.awito.entity.Ad;
import com.example.awito.entity.Role;
import com.example.awito.entity.User;
import com.example.awito.repo.AdRepo;
import com.example.awito.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private AdRepo adRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/")
    public String main(
        @AuthenticationPrincipal User user,
        Model model) {
        Iterable<Ad> ad = adRepo.findAll();
        if (user != null){
            model.addAttribute("isAdmin", user.isAdmin());
        }
        model.addAttribute("ad", ad);
        return "main";
    }

    @PostMapping("/")
    public String ban(@RequestParam Long userId, Model model){
        User user = userRepo.findById(userId);
        Ad ad = adRepo.findByAuthor(user);

        if (user != null && ad != null){
            user.setBanned(true);
            adRepo.delete(ad);
        }
        model.addAttribute("ad", adRepo.findAll());
        return "main";
    }

    @GetMapping("/authentication")
    public String authentication(){
        return "authentication";
    }





}
