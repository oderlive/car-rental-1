package com.example.carrental.model;
import jakarta.persistence.*;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String message;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
}