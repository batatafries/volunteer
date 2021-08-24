package com.example.volunteer.Controllers;

import com.example.volunteer.Models.DBVolunteer;
import com.example.volunteer.Models.Post;
import com.example.volunteer.Repositories.DBVolunteerRepository;
import com.example.volunteer.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;

@Controller
public class VolunteerController {

    @Autowired
    DBVolunteerRepository dbVolunteerRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/adoptRequest")
    public RedirectView adoptRequest(Principal p,
                                     @RequestParam Integer id) {
        DBVolunteer volunteer = dbVolunteerRepository.findByUsername(p.getName());
        Post adoptedPost = postRepository.findById(id).get();
        volunteer.addRequest(adoptedPost);
        adoptedPost.setDbVolunteer(volunteer);
        adoptedPost.setStatus("PROCESSING");
        postRepository.save(adoptedPost);
        dbVolunteerRepository.save(volunteer);
        return new RedirectView("/requests");
    }

    @GetMapping("/volunteer/{username}")
    public String getVolunteer(@PathVariable("username") String username, Model m,Principal p) {
        DBVolunteer volunteer = dbVolunteerRepository.findByUsername(username);
        m.addAttribute("currentUser", volunteer);
        m.addAttribute("cards", volunteer.getvSkills());
        if(p!=null){
            if (p.getName().equals(volunteer.getUsername())){
                return ("volunteerProfile.html");
            }
        }
        return ("volunteerpage.html");
    }
}
