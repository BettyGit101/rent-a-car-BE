package com.elbit.rentYourCar.service;

import com.elbit.rentYourCar.model.Car;
import com.elbit.rentYourCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getListOfCars() {
        return carRepository.findAll();
    }

    public void addNewCar(Car newCar) throws IllegalAccessException {
        Optional<Car> foundCar = carRepository.findById(newCar.getId());
        if (foundCar.isPresent()) {
            throw new IllegalAccessException(("A car with ID " + newCar.getId() + " already exists"));
        }
        carRepository.save(newCar);
    }

    public void deleteCar(Integer idToDelete) {
        boolean isCarPresent = carRepository.existsById(idToDelete);
        if (isCarPresent) {
            carRepository.deleteById(idToDelete);
        } else {
            throw new IllegalStateException("Car with id " + idToDelete + " does not exist in data base");
        }
    }

    public void updateCar(Integer carId, Boolean isAvailable) {
        Car existingCar = carRepository.findById(carId).orElseThrow(()-> new IllegalStateException(
                "car with id: " + carId + " does not exists in DB"
        ));
        if (isAvailable != null) {
            existingCar.setIsAvailable(isAvailable);
            carRepository.save(existingCar);
        }

    }
}
