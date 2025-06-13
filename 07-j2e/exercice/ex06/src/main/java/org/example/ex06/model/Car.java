package org.example.ex06.model;

import java.time.LocalDate;

public class Car {

    private int id;
    private String brand;
    private LocalDate date;
    private String color;

    public Car() {}

    public Car(int id, String brand, LocalDate date, String color) {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
