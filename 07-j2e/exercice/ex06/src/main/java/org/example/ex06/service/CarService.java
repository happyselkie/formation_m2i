package org.example.ex06.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ex06.model.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarService {

    private List<Car> cars;
    private int idAuto;

    public CarService() {
        cars = new ArrayList<>();
        idAuto = 1;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCar(int id) {
        Car carGet = null;
        for (Car car : cars) {
            if (car.getId() == id) {
                carGet = car;
            }
        }
        return carGet;
    }

    public Car save(String brand, String date, String color) {
        Car car = new Car(idAuto++, brand, LocalDate.parse(date), color);
        cars.add(car);

        return car;
    }

    public Car update(int id, String brand, String date, String color) {
        Car car = getCar(id);
        car.setBrand(brand);
        car.setDate(LocalDate.parse(date));
        car.setColor(color);

        return car;
    }

    public int delete(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                cars.remove(car);
            }
        }
        return cars.size();
    }


}
