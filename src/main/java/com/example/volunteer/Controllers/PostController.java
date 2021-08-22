package com.example.volunteer.Controllers;

import com.example.volunteer.Models.DBUser;
import com.example.volunteer.Models.Post;
import com.example.volunteer.Repositories.DBUserRepository;
import com.example.volunteer.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    PostRepository postRepository;

    @Autowired
    DBUserRepository dbUserRepository;

    @GetMapping("/requests")
    public String getAllRequests(Model m){
        m.addAttribute("allRequests",postRepository.findAll());
        return "requests.html";
    }
}
