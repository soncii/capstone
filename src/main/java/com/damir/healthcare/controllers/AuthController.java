package com.damir.healthcare.controllers;

import com.damir.healthcare.entities.Doctor;
import com.damir.healthcare.entities.Statistician;
import com.damir.healthcare.entities.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logoutsuccess")
    public String logout(){
        return "redirect:login";
    }
    @GetMapping("/register/doctor")
    @PreAuthorize("permitAll()")
    public String addDoctor(Model model){
        User user = new User();
        model.addAttribute("User",user);
        model.addAttribute("Doctor", new Doctor());
        return "admin/addnewdoctor";
    }
    @GetMapping("/register/statistician")
    @PreAuthorize("permitAll()")
    public String addUser(Model model){
        model.addAttribute("User",new User());
        model.addAttribute("Statistician", new Statistician());
        return "admin/addnewstatistician";
    }
}
