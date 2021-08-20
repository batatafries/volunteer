package com.example.volunteer.Controllers;

import com.example.volunteer.Models.Post;
import com.example.volunteer.Models.UserS;
import com.example.volunteer.Repositories.PostRepository;
import com.example.volunteer.Repositories.UserRepository;
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
    UserRepository userRepository;

    @GetMapping("/askForHelp")
    public String getAskForHelp(){
        return "askforhelp.html";
    }

    @PostMapping("/addPost")
    public RedirectView getAskForHelp(@RequestParam String body,@RequestParam String field ,
                                      @RequestParam Integer phone,@RequestParam String date ,
                                      @RequestParam String time, Principal p){
        UserS user = userRepository.findByUsername(p.getName());
        Post post = new Post(body, field,date,time,phone,user);
        postRepository.save(post);
        return new RedirectView("/askForHelp");
    }
}
