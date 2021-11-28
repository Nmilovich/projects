package com.example.awito.controller;

import com.example.awito.entity.Ad;
import com.example.awito.entity.User;
import com.example.awito.repo.AdRepo;
import com.example.awito.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AddAdController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AdRepo adRepo;

    @GetMapping("/account")
    public String account(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("username", user.getUsername());
        return "account";
    }

    @PostMapping("/account")
    public String addAd(
            @AuthenticationPrincipal User user,
            @Valid Ad ad,
            BindingResult bindingResult,
            Model model){

        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "account";
        }
        ad.setAuthor(user);
        adRepo.save(ad);
        return "account";
    }
    @GetMapping("/back")
    public String backMainPage(){
        return "redirect:/";
    }


    /*@PostMapping("/account")
    public String addAd(
            @AuthenticationPrincipal User user,
            @Valid Ad ad,
            @RequestParam String adName,
            @RequestParam Integer price){
        Ad ad = new Ad(user,adName,price);
        adRepo.save(ad);
        return "account";
    }
    @GetMapping("/back")
    public String backMainPage(){
        return "redirect:/";
    }*/

}
