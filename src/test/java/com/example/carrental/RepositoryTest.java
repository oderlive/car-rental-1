package com.example.carrental;
import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private CarRepository repo;

    @Test
    void testSaveCar() {
        Car car = new Car();
        car.setName("Audi");
        Car saved = repo.save(car);
        assertNotNull(saved.getId());
    }

    @Test
    void testFindAllCars() {
        List<Car> cars = repo.findAll();
        assertNotNull(cars);
    }

    @Test
    void testSaveMultipleCars() {
        Car car1 = new Car();
        car1.setName("BMW");
        Car car2 = new Car();
        car2.setName("Tesla");
        repo.save(car1);
        repo.save(car2);
        assertTrue(repo.findAll().size() >= 2);
    }

    @Test
    void testCarNameAfterSave() {
        Car car = new Car();
        car.setName("Mercedes");
        Car saved = repo.save(car);
        assertEquals("Mercedes", saved.getName());
    }

    @Test
    void testRepositoryExists() {
        assertNotNull(repo);
    }

    @Test
    void testFindById() {
        Car car = new Car();
        car.setName("Toyota");
        Car saved = repo.save(car);
        Car found = repo.findById(saved.getId()).orElse(null);
        assertNotNull(found);
    }
}