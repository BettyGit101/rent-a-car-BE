package com.elbit.rentYourCar.controller;

import com.elbit.rentYourCar.model.Car;
import com.elbit.rentYourCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/v1/car")

public class CarController   {

    @Autowired
    private CarService carService;


    @GetMapping
    public List<Car> getListOfCars() {
        return carService.getListOfCars();
    }

    @PostMapping
    public void addNewCar(@RequestBody @Valid Car newCar) throws IllegalAccessException {
        carService.addNewCar(newCar);
    }

    @DeleteMapping(path="/{carIdToDelete}")
    public void deleteCar(@PathVariable("carIdToDelete") Integer idToDelete) {
        carService.deleteCar(idToDelete);
    }

    @PutMapping(path="/{carIdToUpdate}")
    public void updateCar(@PathVariable("carIdToUpdate") Integer carId,
                          @RequestParam(required = true) Boolean isAvailable) {
        carService.updateCar(carId,isAvailable);
    }
}
