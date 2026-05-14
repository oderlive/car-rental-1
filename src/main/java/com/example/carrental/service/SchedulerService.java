package com.example.carrental.service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class SchedulerService {

    @Scheduled(fixedRate = 30000)
    public void scheduledTask() {
        System.out.println("Напоминание: проверьте новые заявки на аренду автомобилей");
        System.out.println("Время проверки: " + LocalDateTime.now());
    }
}