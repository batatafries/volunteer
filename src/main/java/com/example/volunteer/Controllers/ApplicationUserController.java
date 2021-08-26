package com.example.volunteer.Controllers;

import com.example.volunteer.Models.DBUser;
import com.example.volunteer.Models.DBVolunteer;
import com.example.volunteer.Models.Post;
import com.example.volunteer.Repositories.DBUserRepository;
import com.example.volunteer.Repositories.DBVolunteerRepository;
import com.example.volunteer.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ApplicationUserController {

    @Autowired
    DBUserRepository DBUserRepository;

    @Autowired
    DBVolunteerRepository dbVolunteerRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
    PostRepository postRepository;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup.html";
    }


    @GetMapping("/login")
    public String getSignInPage() {
        return "signin1.html";
    }

    @GetMapping("/login/error")
    public String getSignInErrorPage(Model m) {
        m.addAttribute("errorMsg",true);
        return "signin1.html";
    }

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName,
                               @RequestParam(value = "dateOfBirth") String dateOfBirth,
                               @RequestParam(value = "type") String typeOfUser
    ) {
        if (typeOfUser.equals("Volunteer")) {
            DBVolunteer newVolunteer = new DBVolunteer(username, bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, "ROLE_VOLUNTEER");
            dbVolunteerRepository.save(newVolunteer);
        }
        if (typeOfUser.equals("User")) {
            DBUser newUser = new DBUser(username, bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, "ROLE_USER");
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

    @GetMapping("/myprofile")
    public String getProfile(Principal p, Model m) {
        DBUser currentUser = DBUserRepository.findByUsername(p.getName());
        if (currentUser != null) {
            m.addAttribute("currentUser", currentUser);
            m.addAttribute("requests", currentUser.getPost());
            m.addAttribute("reviews", currentUser.getUserReviews());
            return "profile.html";
        }
        DBVolunteer currentUser1 = dbVolunteerRepository.findByUsername(p.getName());
        if (currentUser1 != null) {
            m.addAttribute("currentUser", currentUser1);
            m.addAttribute("cards", currentUser1.getvSkills());
            m.addAttribute("reviews", currentUser1.getVolunteerReviews());
            return "volunteerProfile.html";
        }
        throw new NullPointerException();
    }
@GetMapping("/getcard/{id}")
public String getCardToModify(Model m,@PathVariable Integer id  ){
        Post p1 =postRepository.findById(id).get();
        m.addAttribute("cardUpdate",p1);
        m.addAttribute("show",true);
        return "modaltest.html";
}

    @GetMapping("/{username}")
    public String getVolunteer(@PathVariable("username") String username, Model m, Principal p) {
        DBUser user = DBUserRepository.findByUsername(username);
        m.addAttribute("currentUser", user);
        m.addAttribute("requests", user.getPost());
        m.addAttribute("reviews", user.getUserReviews());
        if (p != null) {
            if (p.getName().equals(user.getUsername())) {
                return ("profile.html");
            }
            m.addAttribute("p",p.getName());
        }
        return ("userpage1.html");
    }

    @PostMapping("/modifyRequest")
    public RedirectView modifyRequest(@RequestParam String body ,
                                      @RequestParam String field ,
                                      @RequestParam String phone ,
                                      Principal p,
                                      @RequestParam Integer id,
                                      Model m) {
        Post post = postRepository.findById(id).get();
        String loggedInUserName = p.getName();
        DBUser loggedInUser = DBUserRepository.findByUsername(loggedInUserName);
        if(loggedInUser.getId().equals(post.getUser().getId())){
            post.setBody(body);
            post.setField(field);
//            post.setTime(time);
//            post.setDate(date);
            post.setPhone(phone);
            postRepository.save(post);
        }
        m.addAttribute("show",false);
        return new RedirectView("/myprofile");
    }


}
