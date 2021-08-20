package com.example.volunteer.Controllers;

import com.example.volunteer.Models.Post;
import com.example.volunteer.Models.UserS;
import com.example.volunteer.Models.VSkill;
import com.example.volunteer.Models.Volunteer;
import com.example.volunteer.Repositories.VSkillRepository;
import com.example.volunteer.Repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class VSkillController {

    @Autowired
    VSkillRepository vSkillRepository;

    @Autowired
    VolunteerRepository volunteerRepository;

    @GetMapping("/volunteerPage")
    public String getAskForHelp() {
        return "volunteer.html";
    }

    @PostMapping("/addVolunteer")
    public RedirectView getVolunteerPage(@RequestParam String description,
                                         @RequestParam String skills,
                                         @RequestParam String email,
                                         @RequestParam String field,
                                         Principal p) {
        String username = p.getName();
        Volunteer volunteer = volunteerRepository.findByUsername(username);
        VSkill vSkill = new VSkill(volunteer,description, skills, field, email);
        vSkillRepository.save(vSkill);
        return new RedirectView("/volunteerPage");
    }
}

