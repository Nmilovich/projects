package com.example.awito.controller;

import com.example.awito.entity.User;
import com.example.awito.entity.dto.CaptchaResponseDTO;
import com.example.awito.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Value("${recaptcha.secret}")
    private String secret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    /*passwordСonfirmation был как поле в сущности use с @Transient и @NotBlank, но
    @NotBlank(message = "password2 cannot be empty")
    выдавал ошибку при поддверждении почты*/
    @PostMapping("/registration")
    public String addUser(
            @RequestParam("g-recaptcha-response") String captchaResponse,
            @RequestParam String password2,
            @Valid User user,
            BindingResult bindingResult,
            Model model) {

        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDTO capthcaResponse = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDTO.class);

        if (!capthcaResponse.isSuccess()){
            model.addAttribute("captchaError","fill a captcha");
        }
        if (StringUtils.isEmpty(password2)){
            model.addAttribute("Password2Error","Password confirmation cannot be empty");
        }

        if (user.getPassword() != null && !user.getPassword().equals(password2)){
            model.addAttribute("passwordError", "passwords are different");
            return "registration";
        }
        if (bindingResult.hasErrors() || !capthcaResponse.isSuccess()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            //тоже самое что model.addAttribute("errors", errors); но объект по названию переменной
            model.mergeAttributes(errors);

            return "registration";
        }

        if (!userService.addUser(user)){
            model.addAttribute("usernameError","name is exists");
            return "registration";
        }

        return "redirect:/authentication";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code, Model model){
        boolean isActivated = userService.activateUser(code);

        if (isActivated){
            model.addAttribute("message", "User successfully activated");
        } else{
            model.addAttribute("message", "Activation code is not found");
        }

        return "login";
    }




}
