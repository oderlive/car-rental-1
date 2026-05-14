package com.example.carrental;
import com.example.carrental.model.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {
    @Test
    void testCarCreation() {
        Car car = new Car();
        car.setName("BMW");
        assertEquals("BMW", car.getName());
    }

    @Test
    void testCarNameNotNull() {
        Car car = new Car();
        car.setName("Audi");
        assertNotNull(car.getName());
    }

    @Test
    void testCarNameDifferent() {
        Car car = new Car();
        car.setName("Tesla");
        assertNotEquals("BMW", car.getName());
    }

    @Test
    void testCarObjectExists() {
        Car car = new Car();
        assertNotNull(car);
    }

    @Test
    void testSetAndGetName() {
        Car car = new Car();
        car.setName("Mercedes");
        assertEquals("Mercedes", car.getName());
    }

    @Test
    void testEmptyName() {
        Car car = new Car();
        car.setName("");
        assertTrue(car.getName().isEmpty());
    }
}