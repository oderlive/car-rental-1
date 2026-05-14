package com.example.carrental.service;
import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {
    private final CarRepository repo;
    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    @Cacheable("cars")
    public List<Car> getAllCars() {
        long start = System.currentTimeMillis();
        System.out.println("Загрузка машин из БД...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Car> cars = repo.findAll();
        long end = System.currentTimeMillis();
        System.out.println("Время загрузки без кэша: " + (end - start) + " ms");
        return cars;
    }
}