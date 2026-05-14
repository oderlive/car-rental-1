package com.example.carrental.service;
import com.example.carrental.model.Feedback;
import com.example.carrental.repository.FeedbackRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncFeedbackService {
    private final FeedbackRepository repo;
    public AsyncFeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }

    @Async
    public void saveFeedback(Feedback feedback) {
        System.out.println("START async feedback saving");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repo.save(feedback);
        System.out.println("Feedback saved async");
        System.out.println("END async feedback saving");
    }
}