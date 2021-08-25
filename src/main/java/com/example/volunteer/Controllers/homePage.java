package com.example.volunteer.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class homePage {

    @GetMapping("/")
    public String getHome(){
        return "Homee";
    }

}
