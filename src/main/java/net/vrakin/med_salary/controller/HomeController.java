package net.vrakin.med_salary.controller;

import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@Slf4j
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String admin(){
        log.info("Accessing admin page");
        return "admin";
    }

    @GetMapping("/nadmin")
    public ModelAndView newAdminPanel(){
        log.info("Accessing nadmin page");
        ModelAndView mav = new ModelAndView("nadmin");

        mav.addObject("users", userService.findAll());
        mav.addObject("pageTitle", "User Manager");
        return mav;
    }

    @GetMapping("/login")
    public String login(){
        log.info("Accessing login page");
        return "login";
    }

    @GetMapping("/")
    public String index(){
        log.info("Accessing index page");
        return "index";
    }
}
