package com.example.volunteer.Controllers;

import com.example.volunteer.Models.DBUser;
import com.example.volunteer.Models.DBVolunteer;
import com.example.volunteer.Models.Post;
import com.example.volunteer.Models.Reviews;
import com.example.volunteer.Repositories.DBReviewsRepository;
import com.example.volunteer.Repositories.DBUserRepository;
import com.example.volunteer.Repositories.DBVolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ReviewController {

    @Autowired
    DBVolunteerRepository dbVolunteerRepository;

    @Autowired
    DBReviewsRepository dbReviewsRepository;

    @Autowired
    DBUserRepository dbUserRepository;

    @PostMapping("/addReview")
    public RedirectView getReview(@RequestParam String body, Principal p, @RequestParam Integer id) {
        DBUser user = dbUserRepository.findByUsername(p.getName());
        DBVolunteer reviewdVolunteer = dbVolunteerRepository.findById(id).get();
        Reviews review = new Reviews(body, user.getUsername());
        review.setReviewedVolunteer(reviewdVolunteer);
        reviewdVolunteer.addReview(review);
        dbVolunteerRepository.save(reviewdVolunteer);
        dbReviewsRepository.save(review);
        return new RedirectView("/volunteer/" + reviewdVolunteer.getUsername());
    }

    @PostMapping("/addReviewUser")
    public RedirectView getReviewForUser(@RequestParam String body, Principal p, @RequestParam Integer id) {
        DBVolunteer volunteer = dbVolunteerRepository.findByUsername(p.getName());
        DBUser reviewdUser = dbUserRepository.findById(id).get();
        Reviews review = new Reviews(body, volunteer.getUsername());
        review.setReviewedUser(reviewdUser);
        reviewdUser.addReview(review);
        dbUserRepository.save(reviewdUser);
        dbReviewsRepository.save(review);
        return new RedirectView("/" + reviewdUser.getUsername());
    }


    @PostMapping("/deleteReview")
    public RedirectView deleteReview(@RequestParam Integer id, Principal p) {
        Reviews reqReview = dbReviewsRepository.findById(id).get();
        DBVolunteer volunteer = dbVolunteerRepository.findByUsername(reqReview.getReviewerName());
//        m.addAttribute("p",p.getName());
//        System.out.println(id);
//        System.out.println(p.getName());
        dbReviewsRepository.deleteById(id);
        if (volunteer != null) {
            return new RedirectView("/user/" + reqReview.getReviewedUser().getUsername());
        }
        DBUser user = dbUserRepository.findByUsername(reqReview.getReviewerName());
        if (user != null) {
            return new RedirectView("/volunteer/" + reqReview.getReviewedVolunteer().getUsername());
        }
        return new RedirectView("/") ;
    }

}