package net.vrakin.med_salary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String admin(){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
