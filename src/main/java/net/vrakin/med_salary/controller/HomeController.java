package net.vrakin.med_salary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/hello-world")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello-world";
    }

    @GetMapping("message-expression")
    public String messageExpression(){
        return "message-expression";
    }
}
