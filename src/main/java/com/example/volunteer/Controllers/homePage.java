package com.example.volunteer.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homePage {

    @GetMapping("/")
    public String getHome(){
        return "Homee";
    }

    @GetMapping("/About_Us")
    public String getAboutUs(){
        return "About_Us";
    }
}
