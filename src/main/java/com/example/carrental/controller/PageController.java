package com.example.carrental.controller;
import com.example.carrental.model.Page;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.carrental.model.Car;
import com.example.carrental.model.Order;
import com.example.carrental.repository.OrderRepository;

@Controller
public class PageController {

    private final PageService pageService;
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;

    public PageController(PageService pageService,
                      CarRepository carRepository,
                      OrderRepository orderRepository) {
    this.pageService = pageService;
    this.carRepository = carRepository;
    this.orderRepository = orderRepository;
}

    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "gallery";
    }

@GetMapping("/{slug}")
public String page(@PathVariable String slug, Model model) {

    if (slug.equals("error") || slug.equals("favicon.ico")) {
        return "redirect:/";
    }

    Page page = pageService.getBySlug(slug);

    if (page == null) {
        return "error";
    }

    model.addAttribute("page", page);

    return slug;
}



    @GetMapping("/car/{id}")
    public String carPage(@PathVariable Long id, Model model) {
        var car = carRepository.findById(id).orElse(null);

        if (car == null) return "error";

        model.addAttribute("car", car);
        return "car";
    }
    @PostMapping("/order")
    public String order(@RequestParam String name,
                        @RequestParam String phone,
                        @RequestParam Long carId) {

        Car car = carRepository.findById(carId).orElse(null);

        Order order = new Order();
        order.setName(name);
        order.setPhone(phone);
        order.setCar(car);

        orderRepository.save(order);

        return "redirect:/";
    }
}