package com.example.carrental.controller;
import com.example.carrental.model.Feedback;
import com.example.carrental.repository.FeedbackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

    private final FeedbackRepository repo;

    public FeedbackController(FeedbackRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/feedback")
    public String save(@ModelAttribute Feedback feedback) {
        repo.save(feedback);
        return "redirect:/feedback";
    }
}