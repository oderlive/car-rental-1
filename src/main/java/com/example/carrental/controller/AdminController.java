package com.example.carrental.controller;
import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.repository.OrderRepository;

@Controller
public class AdminController {

    private final CarRepository carRepository;
    private final OrderRepository orderRepository;

public AdminController(CarRepository carRepository,
                       OrderRepository orderRepository) {
    this.carRepository = carRepository;
    this.orderRepository = orderRepository;
}

    @GetMapping("/admin/cars")
    public String adminCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "admin-cars";
    }

    @GetMapping("/admin/car/edit/{id}")
    public String editCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).orElse(null));
        return "car-edit";
    }

    @PostMapping("/admin/car/save")
    public String saveCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/admin/cars";
    }

    @GetMapping("/admin/car/new")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "car-edit";
    }

    @GetMapping("/admin/car/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return "redirect:/admin/cars";
    }
    @GetMapping("/admin/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "admin-orders";
    }
}