package com.example.volunteer.Controllers;

import com.example.volunteer.Models.DBUser;
import com.example.volunteer.Models.Post;
import com.example.volunteer.Repositories.DBUserRepository;
import com.example.volunteer.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    DBUserRepository dbUserRepository;

    @GetMapping("/askForHelp")
    public String getAskForHelp(){
        return "askforhelp.html";
    }

    @PostMapping("/addPost")
    public RedirectView getAskForHelp(@RequestParam String body,@RequestParam String field ,
                                      @RequestParam Integer phone,@RequestParam String date ,
                                      @RequestParam String time, Principal p){
        DBUser user = dbUserRepository.findByUsername(p.getName());
        Post post = new Post(body, field,date,time,phone,user);
        postRepository.save(post);
        return new RedirectView("/askForHelp");
    }
}
