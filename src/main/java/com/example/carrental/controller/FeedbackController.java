package com.example.carrental.controller;
import com.example.carrental.model.Feedback;
import com.example.carrental.service.AsyncFeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {
    private final AsyncFeedbackService service;
    public FeedbackController(AsyncFeedbackService service) {
        this.service = service;
    }

    @PostMapping("/feedback")
    public String save(@ModelAttribute Feedback feedback) {
        service.saveFeedback(feedback);
        return "redirect:/feedback";
    }
}