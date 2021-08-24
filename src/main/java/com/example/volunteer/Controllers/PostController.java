package com.example.volunteer.Controllers;

import com.example.volunteer.Models.DBUser;
import com.example.volunteer.Models.DBVolunteer;
import com.example.volunteer.Models.Post;
import com.example.volunteer.Repositories.DBUserRepository;
import com.example.volunteer.Repositories.DBVolunteerRepository;
import com.example.volunteer.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    DBUserRepository DBUserRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    DBVolunteerRepository dbVolunteerRepository;

    @GetMapping("/requests")
    public String getAllRequests(Model m, Principal p) {
        if (p != null) {
            DBVolunteer volunteer = dbVolunteerRepository.findByUsername(p.getName());
            if (volunteer != null) {
                m.addAttribute("isVolunteer", volunteer);
            }
        }
        m.addAttribute("allRequests", postRepository.findAllByOrderByIdAsc());
        return "requests.html";
    }

    @PostMapping("/addRequest")
    public RedirectView getAskForHelp(@RequestParam String body, @RequestParam String field,
                                      @RequestParam String phone, @RequestParam String date,
                                      Principal p) {
        DBUser user = DBUserRepository.findByUsername(p.getName());
        Post post = new Post(body, field, date, phone, user, "PENDING");
        postRepository.save(post);
        return new RedirectView("/myprofile");
    }

    @PostMapping("/deleteRequest")
    public RedirectView deleteRequest(@RequestParam Integer id) {
        System.out.println(id);
        postRepository.deleteById(id);
        return new RedirectView("/myprofile");
    }

//    @PutMapping("/modifyRequest")
//    public RedirectView modifyRequest(@RequestParam String body, @RequestParam String field,
//                                      @RequestParam Integer phone, @RequestParam String date,
//                                      @RequestParam String time,Principal p,@RequestParam Integer id) {
//        Post post = postRepository.findById(id).get();
//        post.setBody(body);
//        post.setField(field);
//        post.setDate(date);
//        post.setPhone(phone);
//        post.setTime(time);
//        postRepository.save(post);
//        return new RedirectView("/myprofile");
//    }

}
