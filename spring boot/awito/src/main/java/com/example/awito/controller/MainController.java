package com.example.awito.controller;

import com.example.awito.entity.Ad;
import com.example.awito.repo.AdRepo;
import com.example.awito.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private AdRepo adRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/")
    public String main(
        Model model) {
        Iterable<Ad> ad = adRepo.findAll();
        model.addAttribute("ad", ad);
    return "main";
    }

    @GetMapping("/authentication")
    public String authentication(){
        return "authentication";
    }





}
