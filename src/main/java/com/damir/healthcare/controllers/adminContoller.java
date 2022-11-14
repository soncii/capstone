package com.damir.healthcare.controllers;

import com.damir.healthcare.auth.AuGroup;
import com.damir.healthcare.auth.AuGroupRepository;
import com.damir.healthcare.entities.Doctor;
import com.damir.healthcare.entities.Statistician;
import com.damir.healthcare.entities.User;
import com.damir.healthcare.repositories.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class adminContoller {
    final
    DiscoveryRepository discoveryRepository;
    final
    DiseaseTypeRepository diseaseTypeRepository;
    final
    UserRepository userRepository;
    final
    DoctorRepository doctorRepository;
    final
    StatisticianRepository statisticianRepository;
    final
    AuGroupRepository auGroupRepository;
    final
    RecordRepository recordRepository;
    final
    DiseaseRepository diseaseRepository;

    public adminContoller(DiscoveryRepository discoveryRepository, DiseaseTypeRepository diseaseTypeRepository, UserRepository userRepository, DoctorRepository doctorRepository, StatisticianRepository statisticianRepository, AuGroupRepository auGroupRepository, RecordRepository recordRepository, DiseaseRepository diseaseRepository) {
        this.discoveryRepository = discoveryRepository;
        this.diseaseTypeRepository = diseaseTypeRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
        this.statisticianRepository = statisticianRepository;
        this.auGroupRepository = auGroupRepository;
        this.recordRepository = recordRepository;
        this.diseaseRepository = diseaseRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        String curUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if (doctorRepository.findById(curUser).isPresent())
        {
            model.addAttribute("diseases", diseaseRepository.findAll());
            model.addAttribute("discovered",discoveryRepository.findAll());
            return "doctor_main_page";
        }
        if (statisticianRepository.findById(curUser).isPresent())
        {
            model.addAttribute("records",recordRepository.findAll());
            model.addAttribute("id",curUser);
            return "ps/statistician_main_page";
        }
        return "index";
    }

    @GetMapping("/discover")
    public String allDiscovered(Model model){
        model.addAttribute("discovered",discoveryRepository.findAll());
        return "discover";
    }
    @GetMapping("/add/doctor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public String addDoctor(Model model){
        User user = new User();
        model.addAttribute("User",user);
        model.addAttribute("Doctor", new Doctor());
        return "admin/addnewdoctor";
    }
    @GetMapping("/add/statistician")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addUser(Model model){
        model.addAttribute("User",new User());
        model.addAttribute("Statistician", new Statistician());
        return "admin/addnewstatistician";
    }


    @PostMapping("/save/doctor")
    @PreAuthorize("permitAll()")
    public String saveDoctor(@ModelAttribute("User") User user,
    @ModelAttribute("Doctor") Doctor doctor){
        System.out.println(user.getId()+" "+user.getName()+" "+user.getSurname());
        doctor.setEmail(user.getId());
        userRepository.save(user);
        doctorRepository.save(doctor);
        auGroupRepository.save(new AuGroup(user.getId(),"DOCTOR"));
        return "redirect:/";
    }
    @PostMapping("/save/statistician")
    @PreAuthorize("permitAll()")
    public String saveUser12(@ModelAttribute("User") User user,
                             @ModelAttribute("Statistician") Statistician ps){
        System.out.println(user.getId()+" "+user.getName()+" "+user.getSurname());
        ps.setEmail(user.getId());
        userRepository.save(user);
        auGroupRepository.save(new AuGroup(user.getId(),"PUBLICSERVANT"));
        //statisticianRepository.save(ps);
        return "redirect:/";
    }
    @GetMapping("/see/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String allUsers(Model model){
        model.addAttribute("Users", userRepository.findAll());
        return "admin/seeusers";
    }
    @GetMapping("/modify/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String modifyUser(@PathVariable("id")String string, Model model){
        model.addAttribute("User",userRepository.findById(string).get());
        return "admin/modifyuser";
    }
    @PostMapping("/delete/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable("id") String email, Model model) {
        if (doctorRepository.findById(email).isPresent()) doctorRepository.deleteById(email);
        if (statisticianRepository.findById(email).isPresent()) statisticianRepository.deleteById(email);
        if (auGroupRepository.findById(email).isPresent()) auGroupRepository.deleteById(email);
        if (userRepository.findById(email).isPresent()) userRepository.deleteById(email);
        return "redirect:/see/users";
    }
}
