package org.example.ex06;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.ex06.model.Car;
import org.example.ex06.service.CarService;

import java.util.List;

@Path("/cars")
public class CarResource {

    CarService carService;

    @Inject
    public CarResource(CarService service) {
        carService = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GET
    @Path("/details/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") int id) {
        return carService.getCar(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Car createCar(Car car) {
        return carService.save(car.getBrand(),car.getYear(), car.getColor());
    }

    @POST
    @Path("/create-with-service")
    @Produces(MediaType.APPLICATION_JSON)
    public Car createCarWithService(){
        return carService.save("Peugeot", 2024, "blue");
    }

    @POST
    @Path("/create-with-params")
    @Produces(MediaType.APPLICATION_JSON)
    public Car createCarWithParams(@QueryParam("brand") String brand, @QueryParam("year") int year, @QueryParam("color") String color) {
        return carService.save(brand, year, color);
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCarWithParams(@PathParam("id") int id, @QueryParam("brand") String brand, @QueryParam("year") int year, @QueryParam("color") String color) {
        return carService.update(id, brand, year, color);
    }

    @DELETE
    @Path("/delete/{id}")
    public int deleteCar(@PathParam("id") int id) {
        return carService.delete(id);
    }
}