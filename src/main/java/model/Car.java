package com.example.cars.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import model.CarColor;
import model.CarType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {


    @Id
     @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

@Column
    private String modelName;

@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarType type;

@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarColor color;

private String descripiton;
}

