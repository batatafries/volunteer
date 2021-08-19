package com.example.volunteer.Controllers;

import com.example.volunteer.Models.UserS;
import com.example.volunteer.Models.Volunteer;
import com.example.volunteer.Repositories.UserRepository;
import com.example.volunteer.Repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    VolunteerRepository volunteerRepository;

    @GetMapping("/login")
    public String getSignInPage(){
        return "signin.html";
    }
    @GetMapping("/signup")
    public String signUpPage(){
        return "signup.html";
    }
    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName,
                               @RequestParam(value = "dateOfBirth") String dateOfBirth,
                               @RequestParam(value = "bio") String bio,
                               @RequestParam(value = "type") String typeOfUser
    ) {
        if(typeOfUser.equals("User")){
            UserS newUser = new UserS(username, bCryptPasswordEncoder.encode(password),firstName,lastName,bio,dateOfBirth);
            userRepository.save(newUser);
        }else if(typeOfUser.equals("Volunteer")){
            Volunteer newUser = new Volunteer(firstName,lastName,dateOfBirth,bio,username,bCryptPasswordEncoder.encode(password));
            volunteerRepository.save(newUser);
        }
        return new RedirectView("/login");
    }
}

