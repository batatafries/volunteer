package com.example.volunteer.Controllers;

import com.example.volunteer.Models.*;
import com.example.volunteer.Repositories.DBVolunteerRepository;
import com.example.volunteer.Repositories.VSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class VSkillController {

    @Autowired
    VSkillRepository vSkillRepository;

    @Autowired
    DBVolunteerRepository dbVolunteerRepository;

    @GetMapping("/volunteerSkill")
    public String getVolunteerSkill(Model m) {
        m.addAttribute("allSkillsCards",vSkillRepository.findAll());
        return "volunteerSkill.html";
    }

    @PostMapping("/addSkill")
    public RedirectView getVolunteerPage(@RequestParam String description,
                                         @RequestParam String skills,
                                         @RequestParam String email,
                                         @RequestParam String field,
                                         Principal p) {
        String username = p.getName();
        DBVolunteer volunteer = dbVolunteerRepository.findByUsername(username);
        VSkill vSkill = new VSkill(volunteer, description, skills, field, email);
        vSkillRepository.save(vSkill);
        return new RedirectView("/myprofile");
    }

    @PostMapping("/deleteSkillCard")
    public RedirectView deleteRequest(@RequestParam Integer id) {
        vSkillRepository.deleteById(id);
        return new RedirectView("/myprofile");
    }

    @PostMapping("/modifySkillCard")
    public RedirectView modifyRequest(@RequestParam String description,
                                      @RequestParam String email,
                                      @RequestParam String field,
                                      Principal p,@RequestParam Integer id) {
        VSkill skillCard = vSkillRepository.findById(id).get();
        skillCard.setDescription(description);
        skillCard.setField(field);
        skillCard.setEmail(email);
        vSkillRepository.save(skillCard);
        return new RedirectView("/myprofile");
    }

}

