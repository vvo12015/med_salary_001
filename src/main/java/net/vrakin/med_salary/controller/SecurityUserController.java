package net.vrakin.med_salary.controller;

import net.vrakin.med_salary.domain.SecurityUser;
import net.vrakin.med_salary.mapper.SecurityUserMapper;
import net.vrakin.med_salary.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web/s-users")
public class SecurityUserController {

    private final SecurityUserService securityUserService;
    private final SecurityUserMapper securityUserMapper;

    @Autowired
    public SecurityUserController(SecurityUserService securityUserService,
                                  SecurityUserMapper securityUserMapper) {
        this.securityUserService = securityUserService;
        this.securityUserMapper = securityUserMapper;
    }

    @GetMapping
    public String getFirstUser(Model model) {
        List<SecurityUser> securityUsers = securityUserService.findAll();
        model.addAttribute("users", securityUserMapper.toDtoList(securityUsers));

        return "admin";
    }
}
