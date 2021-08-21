package com.example.volunteer.Controllers;

import com.example.volunteer.Models.DBUser;
import com.example.volunteer.Models.DBVolunteer;
import com.example.volunteer.Repositories.DBUserRepository;
import com.example.volunteer.Repositories.DBVolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {

    @Autowired
    DBUserRepository DBUserRepository;

    @Autowired
    DBVolunteerRepository dbVolunteerRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup.html";
    }

    @GetMapping("/login")
    public String getSignInPage() {
        return "signin.html";
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
        if (typeOfUser.equals("Volunteer")) {
            DBVolunteer newVolunteer = new DBVolunteer(username, bCryptPasswordEncoder.encode(password), firstName, lastName, bio, dateOfBirth, "ROLE_VOLUNTEER");
            dbVolunteerRepository.save(newVolunteer);
        }
        if (typeOfUser.equals("User")) {
            DBUser newUser = new DBUser(username, bCryptPasswordEncoder.encode(password), firstName, lastName, bio, dateOfBirth, "ROLE_USER");
            DBUserRepository.save(newUser);
        }
        return new RedirectView("/login");
    }

    @GetMapping("/volunteerPage")
    public String getVolunteerPage() {
        return "volunteerPage.html";
    }
    @GetMapping("/userPage")
    public String getUserPage() {
        return "userPage.html";
    }
}
