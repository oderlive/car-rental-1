package com.example.carrental.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private String image;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public List<Feedback> getFeedbacks() { return feedbacks; }
}