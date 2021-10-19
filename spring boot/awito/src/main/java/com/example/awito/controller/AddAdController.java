package com.example.awito.controller;

import com.example.awito.entity.Ad;
import com.example.awito.entity.User;
import com.example.awito.repo.AdRepo;
import com.example.awito.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddAdController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AdRepo adRepo;

    @GetMapping("/account")
    public String account(){
        return "account";
    }

    @PostMapping("/account")
    public String addAd(
            @AuthenticationPrincipal User user,
            @RequestParam String adName,
            @RequestParam Integer price){
        Ad ad = new Ad(user,adName,price);
        adRepo.save(ad);
        return "account";
    }
    @GetMapping("/back")
    public String backMainPage(){
        return "redirect:/";
    }

}
