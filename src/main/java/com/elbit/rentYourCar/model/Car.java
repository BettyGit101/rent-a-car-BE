package com.elbit.rentYourCar.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CARS")
public class Car {
    @Id
    private Integer id;

    @NotNull
    @NotEmpty
    private String model;

    @NotNull
    @Column(name = "num_of_seats")
    private Integer numOfSeats;

    @NotNull
    @Column(name = "num_of_doors")
    private Integer numOfDoors;

    @NotNull
    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;

    @NotNull
    @Column(name = "is_air_condition")
    private Boolean isAirCondition;

    @NotNull
    @Column(name = "is_available")
    private Boolean isAvailable;
}
