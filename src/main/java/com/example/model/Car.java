package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

private String description;
}

